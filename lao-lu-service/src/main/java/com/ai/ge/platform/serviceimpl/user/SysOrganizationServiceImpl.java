package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.mapper.user.SysOrganizationMapper;
import com.ai.ge.platform.dto.user.SysOrgaRoleRelDto;
import com.ai.ge.platform.dto.user.SysOrganizationDto;
import com.ai.ge.platform.mapper.user.SysOrgaRoleRelMapper;
import com.ai.ge.platform.model.user.SysOrgaRoleRelExample;
import com.ai.ge.platform.model.user.SysOrganization;
import com.ai.ge.platform.model.user.SysOrganizationExample;
import com.ai.ge.platform.service.user.SysOrganizationService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {
    @Resource
    private SysOrganizationMapper sysOrganizationMapper;

    @Resource
    private SysOrgaRoleRelMapper sysOrgaRoleRelMapper;


    @Override
    public SysOrganization createOrganization(SysOrganizationDto organization) {
        setParentIds(organization);

        organization.setAvailable((short) 1);
        sysOrganizationMapper.insert(organization);
        if (CollectionUtils.isNotEmpty(organization.getSysOrgaRoleRels())) {
            for (SysOrgaRoleRelDto sysOrgaRoleRel : organization.getSysOrgaRoleRels()) {
                sysOrgaRoleRel.setOrgaId(organization.getId());
                sysOrgaRoleRelMapper.insert(sysOrgaRoleRel);
            }
        }
        return organization;
    }


    protected void setParentIds(SysOrganizationDto organization) {
        if (new Long(0).equals(organization.getParentId())) {
            organization.setParentIds(organization.getParentId() + "/");
        } else {
            SysOrganization parent = findOne(organization.getParentId());
            organization.setParentIds(parent.getParentIds() + organization.getParentId() + "/");
        }
    }

    @Override
    public SysOrganization updateOrganization(SysOrganizationDto organization) {
        setParentIds(organization);

        sysOrganizationMapper.updateByPrimaryKeySelective(organization);
        deleteOrgaRoleRel(organization.getId());

        if (CollectionUtils.isNotEmpty(organization.getSysOrgaRoleRels())) {
            for (SysOrgaRoleRelDto sysOrgaRoleRel : organization.getSysOrgaRoleRels()) {
                sysOrgaRoleRel.setOrgaId(organization.getId());
                sysOrgaRoleRelMapper.insert(sysOrgaRoleRel);
            }
        }
        return organization;
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        SysOrganization sysOrganization = sysOrganizationMapper.selectByPrimaryKey(organizationId);
        if (null == sysOrganization) {
            return;
        }

        //子部门，一并删除
        List<Long> sysOrgaIds = sysOrganizationMapper.selectLowerOrgaBySysOrgaId(organizationId);
        if (CollectionUtils.isNotEmpty(sysOrgaIds)) {
            for (Long sysOrgaId : sysOrgaIds) {
                deleteOrgaRoleRel(sysOrgaId);
            }

            SysOrganizationExample organizationExample = new SysOrganizationExample();
            organizationExample.createCriteria().andIdIn(sysOrgaIds);
            sysOrganizationMapper.deleteByExample(organizationExample);
        }

        deleteOrgaRoleRel(organizationId);
        sysOrganizationMapper.deleteByPrimaryKey(organizationId);
    }


    /**
     * 删除部门角色关联数据
     *
     * @param organizationId
     */
    protected void deleteOrgaRoleRel(Long organizationId) {
        SysOrgaRoleRelExample sysOrgaRoleRelExample = new SysOrgaRoleRelExample();
        sysOrgaRoleRelExample.createCriteria().andOrgaIdEqualTo(organizationId);
        sysOrgaRoleRelMapper.deleteByExample(sysOrgaRoleRelExample);
    }

    @Override
    public SysOrganization findOne(Long organizationId) {
        return sysOrganizationMapper.selectByPrimaryKey(organizationId);
    }

    @Override
    public SysOrganizationDto findDtoOne(Long organizationId) {
        return null;
    }

    @Override
    public SysOrganization findParent(SysOrganization parent) {
        String parentIds = parent.getParentIds();
        if (StringUtils.isBlank(parentIds)) {
            return null;
        }
        String[] parIds = parentIds.split("/");
        String parentId = parIds[parIds.length - 1];

        return findOne(Long.parseLong(parentId));
    }

    @Override
    public SysOrganizationDto findOrganizationWithRole(Long organizationId) {
        SysOrganization sysOrganization = findOne(organizationId);
        SysOrganizationDto sysOrganizationDto = new SysOrganizationDto();
        BeanUtils.copyProperties(sysOrganization, sysOrganizationDto);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgaId", organizationId);

        List<SysOrgaRoleRelDto> sysOrgaRoleRelDtos = sysOrgaRoleRelMapper.selectOrgaRoleByOrgaId(params);
        sysOrganizationDto.setSysOrgaRoleRels(sysOrgaRoleRelDtos);

        return sysOrganizationDto;
    }

    @Override
    public List<SysOrganization> findAll() {
        SysOrganizationExample example = new SysOrganizationExample();
        return sysOrganizationMapper.selectByExample(example);
    }

    @Override
    public List<SysOrganization> findAllWithExclude(SysOrganization excludeOraganization) {
        //return organizationDao.findAllWithExclude(excludeOraganization);
        return null;
    }

    @Override
    public void move(SysOrganization source, SysOrganization target) {
        //organizationDao.move(source, target);
    }

    @Override
    public List<SysOrganization> findForTree() {
        return sysOrganizationMapper.listForTree();
    }

    @Override
    public String getSysOrganizationJson() {
        List<SysOrganization> listObjects = findAll();
        List<Map<String, Object>> listMaps = new ArrayList<Map<String, Object>>();

        if (CollectionUtils.isNotEmpty(listObjects)) {
            for (SysOrganization object : listObjects) {
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("id", object.getId());
                objectMap.put("pId", object.getParentId());
                objectMap.put("name", object.getName());

                listMaps.add(objectMap);
            }
        }


        return JSON.toJSONString(listMaps);
    }

    @Override
    public Set<String> findRoles(String username) {
        return new HashSet<String>(sysOrganizationMapper.findRoles(username));
    }

    @Override
    public Set<String> findPermissions(String username) {
        return new HashSet<String>(sysOrganizationMapper.findPermissions(username));
    }
}
