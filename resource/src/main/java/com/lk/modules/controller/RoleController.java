package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.RoleSearchArgs;
import com.lk.modules.dto.RoleDto;
import com.lk.modules.po.RolePo;
import com.lk.modules.service.RoleService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/role")
@Api(tags = "角色管理模块")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/saveRole")
    @ApiOperation("添加角色")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveRole(@RequestBody RoleDto dto) {
        return R.ok(roleService.saveRole(dto));
    }

    @PutMapping("/updateRole")
    @ApiOperation("修改角色")
    @ApiOperationSupport(order = 2)
    public R updateRole(@RequestBody RoleDto dto) {
        return R.ok(roleService.updateRole(dto));
    }

    @DeleteMapping("/deleteRole")
    @ApiOperation("删除角色")
    @ApiOperationSupport(order = 3)
    public R deleteRole(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(roleService.deleteRole(id));
    }

    @PostMapping("/getRoleList")
    @ApiOperation("查看角色列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<RolePo>> getRoleList(@RequestBody RoleSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<RolePo> list = roleService.getRoleList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getRoleDetails")
    @ApiOperation("查看角色详情")
    @ApiOperationSupport(order = 5)
    public R<RolePo> getRoleDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(roleService.getRoleDetails(id));
    }
}
