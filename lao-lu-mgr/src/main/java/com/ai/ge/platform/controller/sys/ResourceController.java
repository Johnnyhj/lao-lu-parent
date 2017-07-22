package com.ai.ge.platform.controller.sys;

import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.model.user.SysResource;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.user.SysResourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * 系统资源
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Resource
    private SysResourceService resourceService;

    @Resource
    private LogAuthProcessService logAuthProcessService;

    @ModelAttribute("types")
    public SysResource.ResourceType[] resourceTypes() {
        return SysResource.ResourceType.values();
    }

    @RequiresPermissions("resource:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("resourceList", resourceService.findForTree());
        return "resource/list";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        SysResource parent = resourceService.findOne(parentId);
        model.addAttribute("parent", parent);
        SysResource child = new SysResource();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("resource", child);
        model.addAttribute("op", "新增子节点");
        return "resource/edit";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    public String create(SysResource resource, RedirectAttributes redirectAttributes) {
        resourceService.createResource(resource);
        redirectAttributes.addFlashAttribute("resultMsg", "新增子节点成功");

        // 记录增加权限日志
        logAuthProcessService.recordSysResourceLog("", resource, (short) 1, LogAuthRemarkEnum.addSysResource.value);
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("resource", resourceService.findOne(id));
        model.addAttribute("op", "修改");
        return "resource/edit";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SysResource resource, RedirectAttributes redirectAttributes) {
        String oldValJson = JackJson.fromObjectToJson(resource);

        resourceService.updateResource(resource);
        redirectAttributes.addFlashAttribute("resultMsg", "修改成功");

        // 记录修改权限日志
        logAuthProcessService.recordSysResourceLog(oldValJson, resource, (short) 2, LogAuthRemarkEnum.modifySysResource.value);
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        SysResource one = resourceService.findOne(id);
        String oldValJson = JackJson.fromObjectToJson(one);

        resourceService.deleteResource(id);
        redirectAttributes.addFlashAttribute("resultMsg", "删除成功");

        // 记录增加权限日志
        SysResource resource = new SysResource();
        resource.setId(id);
        logAuthProcessService.recordSysResourceLog(oldValJson, resource, (short) 3, LogAuthRemarkEnum.deleteSysResource.value);

        return "redirect:/resource";
    }


}
