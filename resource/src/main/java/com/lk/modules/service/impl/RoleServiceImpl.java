package com.lk.modules.service.impl;

import com.lk.modules.args.RoleSearchArgs;
import com.lk.modules.dto.RoleDto;
import com.lk.modules.mapper.RoleMapper;
import com.lk.modules.po.RolePo;
import com.lk.modules.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Boolean saveRole(RoleDto dto) {
        return roleMapper.saveRole(dto);
    }

    @Override
    public Boolean updateRole(RoleDto dto) {
        return roleMapper.updateRole(dto);
    }

    @Override
    public Boolean deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    public List<RolePo> getRoleList(RoleSearchArgs args) {
        return roleMapper.getRoleList(args);
    }

    @Override
    public RolePo getRoleDetails(Integer id) {
        return roleMapper.getRoleDetails(id);
    }
}
