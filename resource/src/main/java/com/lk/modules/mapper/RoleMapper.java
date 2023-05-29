package com.lk.modules.mapper;

import com.lk.modules.args.RoleSearchArgs;
import com.lk.modules.dto.RoleDto;
import com.lk.modules.po.RolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    Boolean saveRole(RoleDto dto);

    Boolean updateRole(RoleDto dto);

    Boolean deleteRole(@Param("id") Integer id);

    List<RolePo> getRoleList(RoleSearchArgs args);

    RolePo getRoleDetails(@Param("id") Integer id);
}
