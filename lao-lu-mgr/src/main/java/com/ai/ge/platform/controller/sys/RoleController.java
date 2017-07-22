package com.ai.ge.platform.controller.sys;

import com.ai.ge.platform.model.user.SysRole;
import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.dto.sys.SysRoleDto;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.model.user.SysRoleResourceReleation;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.user.SysResourceService;
import com.ai.ge.platform.service.user.SysRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private SysRoleService roleService;

    @Resource
    private SysResourceService resourceService;

    @Resource
    private LogAuthProcessService logAuthProcessService;

    @RequiresPermissions("role:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<SysRoleDto> roleList = roleService.findAllRoleResource();
        setResourceIds(roleList);

        model.addAttribute("roleList", roleList);
        return "role/list";
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("role", new SysRole());
        model.addAttribute("op", "新增");
        return "role/edit";
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SysRoleDto role, RedirectAttributes redirectAttributes) {
        // 将ResourceIds转换成角色资源列表
        makeRoleResourceRelations(role);

        roleService.createRoleResource(role);
        redirectAttributes.addFlashAttribute("resultMsg", "新增成功");

        // 记录新增角色日志
        logAuthProcessService.recordRoleLog("", role, (short) 1, LogAuthRemarkEnum.addRole.value);
        return "redirect:/role";
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        SysRoleDto roleResource = roleService.findRoleResource(id);

        // 将角色资源列表转换成ResourceIds
        roleResource.setResourceIds(makeResourceIds(roleResource.getSysRoleResourceRelations()));

        model.addAttribute("role", roleResource);
        model.addAttribute("op", "修改");
        return "role/edit";
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SysRoleDto role, RedirectAttributes redirectAttributes) {
        String oldValJson = JackJson.fromObjectToJson(role);

        // 将ResourceIds转换成角色资源列表
        makeRoleResourceRelations(role);

        roleService.updateRoleResource(role);
        redirectAttributes.addFlashAttribute("resultMsg", "修改成功");

        // 记录修改角色日志
        logAuthProcessService.recordRoleLog(oldValJson, role, (short) 2, LogAuthRemarkEnum.modifyRole.value);
        return "redirect:/role";
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        SysRoleDto roleResource = roleService.findRoleResource(id);
        // 将角色资源列表转换成ResourceIds
        roleResource.setResourceIds(makeResourceIds(roleResource.getSysRoleResourceRelations()));

        model.addAttribute("role", roleResource);
        model.addAttribute("op", "删除");
        return "role/edit";
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        SysRoleDto roleResource = roleService.findRoleResource(id);
        String oldValJson = JackJson.fromObjectToJson(roleResource);

        roleService.deleteRoleResource(id);
        redirectAttributes.addFlashAttribute("resultMsg", "删除成功");

        // 记录删除角色日志
        SysRoleDto role = new SysRoleDto();
        role.setId(id);
        logAuthProcessService.recordRoleLog(oldValJson, role, (short) 3, LogAuthRemarkEnum.deleteRole.value);
        return "redirect:/role";
    }

    private void setCommonData(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
    }

    private void setResourceIds(List<SysRoleDto> roleList) {
        // 取得全部的资源数据，按父子关系排序
        List<SysResource> resourceList = resourceService.findForTree();

        for(SysRoleDto role : roleList) {
            // 作成当前选中资源Id列表
//            List<Long> ids = role.getListResourceIds();
            List<Long> ids = new ArrayList<Long>();
            if (CollectionUtils.isNotEmpty(role.getSysRoleResourceRelations())) {
                for (SysRoleResourceReleation releation : role.getSysRoleResourceRelations()) {
                    ids.add(releation.getSysResourceId());
                }
            }

            StringBuilder buffer = new StringBuilder();
            int cnt = 0; // 记录子项目的数量
            long preParentId = 0;// 记录前一条数据的ParentId
            long preId = 0;// 记录前一条数据的Id

            for (SysResource res : resourceList) {
                for (Long id : ids) {

                    if (res.getId().equals(id)) {

                        // 追加分组终了标记
                        if (!res.getParentId().equals(preParentId)
                                && !res.getParentId().equals(preId)
                                && cnt > 0) {
                            // 系统管理/配置管理/订单管理/报表管理
                            if (res.getParentIds().split("/").length == 2) {
                                for (int i = 0; i < cnt; i++) {
                                    buffer.append(",}");
                                }
                                cnt = 0;
                            } else {
                                buffer.append(",}");
                                cnt--;
                            }
                        }

                        // 追加分组开始标记
                        if (!res.getParentId().equals(preParentId) && res.getParentId().equals(preId)) {
                            buffer.append(",{");
                            cnt++;
                        }

                        // 添加资源名称
                        if (buffer.length() == 0) {
                            buffer.append(res.getName());
                        } else {
                            buffer.append(",").append(res.getName());
                        }

                        // 记录上一条数据的ParentId和Id
                        if (!res.getParentId().equals(preParentId)) {
                            preParentId = res.getParentId();
                        }
                        preId = res.getId();

                        break;
                    }
                }
            }
            for (int i = 0; i < cnt; i++) {
                buffer.append(",}");
            }

            role.setResourceIds(buffer.toString());
        }
    }

    private String makeResourceIds(List<SysRoleResourceReleation> sysRoleResourceRelations) {
        StringBuffer ss = null;

        if (CollectionUtils.isNotEmpty(sysRoleResourceRelations)) {
            for (SysRoleResourceReleation relation : sysRoleResourceRelations) {
                if (ss == null) {
                    ss = new StringBuffer();
                    ss.append(relation.getSysResourceId());
                } else {
                    ss.append(",").append(relation.getSysResourceId());
                }
            }
        }

        return ss == null ? "" : ss.toString();
    }

    private void makeRoleResourceRelations(SysRoleDto role) {
        if (StringUtils.isNotEmpty(role.getResourceIds())) {
            String[] ids = role.getResourceIds().split(",");

            List<SysRoleResourceReleation> relations = new ArrayList<SysRoleResourceReleation>();
            for(String id : ids) {
                SysRoleResourceReleation relation = new SysRoleResourceReleation();
                relation.setSysResourceId(Long.parseLong(id));
                relation.setSysRoleId(role.getId());
                relations.add(relation);
            }

            role.setSysRoleResourceRelations(relations);
        }
    }
}
