package com.ai.ge.platform.controller.sys;

import com.ai.ge.platform.constant.LogAuthRemarkEnum;
import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.page.PageContext;
import com.ai.ge.platform.service.log.LogAuthProcessService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.util.RequestThreadLocal;
import com.ai.ge.platform.controller.common.BaseController;
import com.ai.ge.platform.model.sys.SystemDataDictionary;
import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by jinlu on 2016/6/16.
 */
@Controller
@RequestMapping("/sysdata")
public class SysDataController extends BaseController{

    @Resource
    private SysDataService sysDataService;

    @Resource
    private LogAuthProcessService logAuthProcessService;

    @RequiresPermissions("sysdata:view")
    @RequestMapping
    public String list(HttpServletRequest request, SystemDataDictionary sysData, ModelMap mm) {
        PageContext page = super.setPageContext(request);

        List<SystemDataDictionary> dataList = sysDataService.listAll(sysData);
        mm.put("dataList", dataList);
        mm.put("page", page);

        PageContext.removeContext();
        return "sysdata/dataList";
    }

    @RequiresPermissions("sysdata:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createForm(Model mm) {
        mm.addAttribute("data", new SystemDataDictionary());
        mm.addAttribute("op", "新增");
        return "sysdata/dataEdit";
    }

    @RequiresPermissions("sysdata:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SystemDataDictionary data, RedirectAttributes redirectAttributes) {

        sysDataService.saveSysData(data);
        redirectAttributes.addFlashAttribute("resultMsg", "新增成功");
        return "redirect:/sysdata";
    }

    @RequiresPermissions("sysdata:update")
    @RequestMapping(value = "/{ddId}/update", method = RequestMethod.GET)
    public String updateForm(@PathVariable("ddId") Long ddId, Model mm) {

        SystemDataDictionary dic = sysDataService.getByDdId(ddId);

        mm.addAttribute("data", dic);
        mm.addAttribute("op", "修改");
        return "sysdata/dataEdit";
    }

    @RequiresPermissions("sysdata:view")
    @RequestMapping(value = "/{ddId}/detail", method = RequestMethod.GET)
    public String formDetail(@PathVariable("ddId") Long ddId, Model mm) {

        SystemDataDictionary dic = sysDataService.getByDdId(ddId);
        mm.addAttribute("data", dic);
        mm.addAttribute("op", null);
        return "sysdata/dataEdit";
    }


    @RequiresPermissions("sysdata:update")
    @RequestMapping(value = "/{ddId}/update", method = RequestMethod.POST)
    public String update(SystemDataDictionary data, RedirectAttributes redirectAttributes) {
        SysUser sysUser = (SysUser) RequestThreadLocal.getHttpThreadWrapper().getRequest().getAttribute("SYSTEM_CURRENT_USER");

        SystemDataDictionary dic = sysDataService.getByDdId(data.getDdId());

        sysDataService.updateSysData(data);

        //记录操作日志
        logAuthProcessService.recordUserLog(JSONArray.fromObject(dic).toString(), sysUser, (short) 1, LogAuthRemarkEnum.modifySysResource.value);
        redirectAttributes.addFlashAttribute("resultMsg", "修改成功");
        return "redirect:/sysdata";
    }

    @RequiresPermissions("sysdata:delete")
    @RequestMapping(value = "/{ddId}/delete", method = RequestMethod.GET)
    public String deleteForm(@PathVariable("ddId") Long ddId, Model mm) {

        SystemDataDictionary dic = sysDataService.getByDdId(ddId);
        mm.addAttribute("data", dic);
        mm.addAttribute("op", "删除");
        return "sysdata/dataEdit";
    }

    @RequiresPermissions("sysdata:delete")
    @RequestMapping(value = "/{ddId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("ddId") Long ddId, RedirectAttributes redirectAttributes) {

        sysDataService.deleteSysData(ddId);
        redirectAttributes.addFlashAttribute("resultMsg", "删除成功");
        return "redirect:/sysdata";
    }
}
