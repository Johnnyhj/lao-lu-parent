package com.ai.ge.platform.controller.sys.organizationmain;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import com.ai.ge.platform.service.user.SysOrganizationService;
import com.ai.ge.platform.service.user.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by count on 17/5/12.
 */
@Service
@AbilityRegister(name = "")
public class BaseOrganizationMain implements IAbility
{
    @Resource
    private SysOrganizationService organizationService;

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public Message execute(Message message)
    {
        return null;
    }
}
