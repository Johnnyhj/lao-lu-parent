package com.ai.ge.platform.controller.sys;

import com.ai.ge.platform.controller.common.BaseController;
import com.ai.ge.platform.dto.user.SysOrganizationDto;
import com.ai.ge.platform.model.user.SysOrganization;
import com.ai.ge.platform.service.user.SysOrganizationService;
import com.ai.ge.platform.service.user.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * 组织结构
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Resource
    private SysOrganizationService organizationService;

    @Resource
    private SysRoleService sysRoleService;

    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        //return "organization/index";
        model.addAttribute("listObjects", organizationService.findForTree());
        return "organization/list";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String showTree(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        return "organization/tree";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        SysOrganization parent = organizationService.findOne(parentId);
        model.addAttribute("parent", parent);
        SysOrganization child = new SysOrganization();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child", child);
        model.addAttribute("roleList", sysRoleService.findAll());
        model.addAttribute("op", "新增");
        //return "organization/appendChild";
        return "organization/edit";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/append", method = RequestMethod.GET)
    public String showAppendForm(ModelMap mm) {
        mm.put("op", "新增");
        mm.put("roleList", sysRoleService.findAll());
        return "organization/edit";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/appendChild", method = RequestMethod.POST)
    public String create(SysOrganizationDto organization) {
        organizationService.createOrganization(organization);
        return "redirect:../organization";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showMaintainForm(@PathVariable("id") Long id, ModelMap mm) {
        SysOrganizationDto organization = organizationService.findOrganizationWithRole(id);
        mm.put("object", organization);
        mm.put("parent", organizationService.findParent(organization));
        mm.put("roleList", sysRoleService.findAll());
        mm.put("op", "更新");
        return "organization/edit";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(SysOrganizationDto organization, RedirectAttributes redirectAttributes) {
        organizationService.updateOrganization(organization);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:../organization";
    }

    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        organizationService.deleteOrganization(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:../";
    }


    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.GET)
    public String showMoveForm(@PathVariable("sourceId") Long sourceId, Model model) {
        SysOrganization source = organizationService.findOne(sourceId);
        model.addAttribute("source", source);
        model.addAttribute("targetList", organizationService.findAllWithExclude(source));
        return "organization/move";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
    public String move(
            @PathVariable("sourceId") Long sourceId,
            @RequestParam("targetId") Long targetId) {
        SysOrganization source = organizationService.findOne(sourceId);
        SysOrganization target = organizationService.findOne(targetId);
        organizationService.move(source, target);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "organization/success";
    }


}
