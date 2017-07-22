package com.ai.ge.platform.controller.sys;

import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.controller.common.CommonController;
import com.ai.ge.platform.dto.user.SysUserDto;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.model.sys.SystemArea;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.model.user.SysUserRoleReleation;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.sys.SystemAreaService;
import com.ai.ge.platform.service.user.SysOrganizationService;
import com.ai.ge.platform.service.user.SysRoleService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.platform.serviceimpl.user.PasswordHelper;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 系统用户
 */
@Controller
@RequestMapping("/user")
public class UserController extends CommonController
{
    @Resource
    private UserService userService;

    @Resource
    private SysOrganizationService organizationService;

    @Resource
    private SysRoleService roleService;

    @Resource
    private LogAuthProcessService logAuthProcessService;

    @Resource
    private PasswordHelper passwordHelper;

    @Resource
    private SystemAreaService systemAreaService;

    /**
     * 用户列表
     *
     * @param model
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping
    public String list(SysUserDto sysUserDto, HttpServletRequest request, Model model) {
        PageContext page = super.setPageContext(request);

        Map<String, Object> params = new TreeMap<String, Object>();
        if (StringUtils.isNotBlank(sysUserDto.getUsername())) {
            params.put("username", sysUserDto.getUsername());
        }
        if (null != sysUserDto.getUserType()) {
            params.put("userType", sysUserDto.getUserType());
        }
        if (null != sysUserDto.getLocked()) {
            params.put("locked", sysUserDto.getLocked());
        }

        model.addAttribute("userList", userService.searchSysUser(params));
        model.addAttribute("page", page);

        PageContext.removeContext();
        return "user/list";
    }

    /**
     * 用户新增
     *
     * @param model
     * @return
     */
    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model, HttpServletRequest request) {
        setCommonData(model);

        model.addAttribute("user", new SysUserDto());
        model.addAttribute("sysOrganizationJson", organizationService.getSysOrganizationJson());
        model.addAttribute("op", "新增");

        // 查询区域相关代码
        // 所有的省
        List<SystemArea> firstLevelAreaList = systemAreaService.listSystemArea(null, null);
        model.addAttribute("areaList", firstLevelAreaList);

        return "user/edit";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SysUserDto user, RedirectAttributes redirectAttributes) {

        String oldValJson = "";

        try {
            userService.checkUserNameUnique(user.getUsername());
            userService.checkPhoneUnique(user.getTelPhone(), null);
        } catch (DataException e) {
            redirectAttributes.addFlashAttribute("msg", "新增失败!");
            return "redirect:/user";
        }

        if (2 == user.getUserType())
        {
            user.setCityAearId(user.getTempAreaId());
        }
        else{
            user.setProvinceAearId(user.getTempAreaId());
        }

        userService.createUser(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");

        // 用户新增日志记录
        logAuthProcessService.recordUserLog(oldValJson, user, (short) 1, LogAuthRemarkEnum.addUser.value);

        return "redirect:/user";
    }

    /**
     * 用户修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        setCommonData(model);
        SysUserDto sysUserDto = userService.findUserWithRole(id);
        setRoleIds(sysUserDto);

        if (sysUserDto.getUserType() == 2)
        {
            sysUserDto.setTempAreaId(sysUserDto.getCityAearId());
        } else
        {
            sysUserDto.setTempAreaId(sysUserDto.getProvinceAearId());
        }

        // 查询区域相关代码
        // 所有的省
        List<SystemArea> firstLevelAreaList = systemAreaService.listSystemArea(null, null);
        model.addAttribute("areaList", firstLevelAreaList);

        model.addAttribute("user", sysUserDto);
        model.addAttribute("op", "修改");
        return "user/edit";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, SysUserDto user, RedirectAttributes redirectAttributes) {

        String type = request.getParameter("type");

        String returnUrl = "redirect:/user";
        if (StringUtils.isNotEmpty(type))
        {
            returnUrl = "redirect:/mgr/index/dashboard";
        }


        String oldValJson = JackJson.fromObjectToJson(user);

        // 校验手机号唯一
        try {
            userService.checkPhoneUnique(user.getTelPhone(), user.getId());
        } catch (DataException e) {

            redirectAttributes.addFlashAttribute("msg", e.getMessage());

            return returnUrl;
        }

        if (2 == user.getUserType())
        {
            user.setCityAearId(user.getTempAreaId());
        }
        else{
            user.setProvinceAearId(user.getTempAreaId());
        }

        userService.updateUser(user);
        redirectAttributes.addFlashAttribute("msg", "修改成功");

        // 用户修改日志记录
        logAuthProcessService.recordUserLog(oldValJson, user, (short) 2, LogAuthRemarkEnum.modifyUser.value);

        return returnUrl;
    }

    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public void delete(@PathVariable("id") Long id, HttpServletResponse response) {
        // 用户删除日志记录
        SysUserDto user = userService.findUser(id);
        String oldUserJson = JackJson.fromObjectToJson(user);
        logAuthProcessService.recordUserLog(oldUserJson, user, (short) 3, LogAuthRemarkEnum.deleteUser.value);

        ObjectResult objectResult = new ObjectResult();

        try
        {
            userService.deleteUser(id);
            objectResult.setResultMsg("删除成功!");
            objectResult.setResultCode("1");
        } catch (Exception e)
        {
            e.printStackTrace();
            objectResult.setResultMsg("删除失败!");
            objectResult.setResultCode("0");
        }
        printJson(objectResult, response);
    }

    /**
     * 用户锁定、解除锁定
     *
     * @param id
     * @param locked
     * @return
     */
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/lock/{locked}", method = RequestMethod.GET)
    public void showLockForm(@PathVariable("id") Long id, @PathVariable("locked") short locked, HttpServletResponse
            response) {

        SysUserDto record = new SysUserDto();
        record.setId(id);
        record.setLocked(locked);
        int i = userService.updateByPrimaryKeySelective(record);

        // 记录修改日志
        // 锁定用户
        if (0 == locked)
        {
            // 解锁用户
            logAuthProcessService.recordUserLog("", record, (short) 2, LogAuthRemarkEnum.unlockUser.value);
        }
        else
        {
            // 锁定用户
            logAuthProcessService.recordUserLog("", record, (short) 2, LogAuthRemarkEnum.lockUser.value);
        }

        ObjectResult objectResult = new ObjectResult();
        objectResult.setResultCode(i + "");

        printJson(objectResult, response);
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/lock/{locked}", method = RequestMethod.POST)
    public String lock(SysUser user, RedirectAttributes redirectAttributes) {
        userService.updateUser(user);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/user";
    }

    /**
     * 修改密码
     *
     * @param id
     * @param model
     * @return
     */
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改密码");

        return "user/changePassword";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    public String changePassword(@PathVariable("id") Long id, HttpServletRequest request, SysUser sysUser, RedirectAttributes
            redirectAttributes) {

        // 如果是个人中心的个人信息密码修改，则需要校验原密码
        String type = request.getParameter("type");
        if (StringUtils.isNotEmpty(type))
        {
            String oldEncryptPassoword = passwordHelper.getEncryptPassword((String) request.getParameter("oldPassword"), sysUser);

            if (!sysUser.getPassword().equals(oldEncryptPassoword))
            {
                redirectAttributes.addFlashAttribute("msg", "原密码输入错误!");

                return "redirect:/mgr/index/dashboard";
            }
        }

        String newPassword = (String) request.getParameter("newPassword");
        if (StringUtils.isEmpty(newPassword))
        {
            return "redirect:/user";
        }

        userService.changePassword(id, newPassword);
        redirectAttributes.addFlashAttribute("msg", "修改密码成功!");

        SysUserDto user = new SysUserDto();
        user.setId(id);
        logAuthProcessService.recordUserLog("", user, (short) 2, LogAuthRemarkEnum.modifyPwdUser.value);

        if (StringUtils.isNotEmpty(type))
        {
            return "redirect:/mgr/index/dashboard";
        }
        else
        {
            return "redirect:/user";
        }
    }

    /**
     * 角色，渠道信息取得
     *
     * @param model
     */
    private void setCommonData(Model model) {
//        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }


    private void setRoleIds(SysUserDto sysUserDto) {
        if (CollectionUtils.isEmpty(sysUserDto.getSysUserRoleReleations())) {
            return;
        }

        StringBuffer s = null;
        for (SysUserRoleReleation role : sysUserDto.getSysUserRoleReleations()) {
            if (s == null) {
                s = new StringBuffer();
                s.append(role.getSysRoleId());
            } else {
                s.append(",").append(role.getSysRoleId());
            }
        }

        sysUserDto.setRoleIds(s.toString());
    }

}
