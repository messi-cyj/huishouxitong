package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.StaffSearchArgs;
import com.lk.modules.dto.StaffDto;
import com.lk.modules.po.StaffPo;
import com.lk.modules.service.StaffService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/staff")
@Api(tags = "员工管理模块")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/saveStaff")
    @ApiOperation("添加员工")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveStaff(@RequestBody StaffDto dto) {
        return R.ok(staffService.saveStaff(dto));
    }

    @PutMapping("/updateStaff")
    @ApiOperation("修改员工")
    @ApiOperationSupport(order = 2)
    public R updateStaff(@RequestBody StaffDto dto) {
        return R.ok(staffService.updateStaff(dto));
    }

    @DeleteMapping("/deleteStaff")
    @ApiOperation("删除员工")
    @ApiOperationSupport(order = 3)
    public R deleteStaff(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(staffService.deleteStaff(id));
    }

    @PostMapping("/getStaffList")
    @ApiOperation("查看员工列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<StaffPo>> getStaffList(@RequestBody StaffSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<StaffPo> list = staffService.getStaffList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getStaffDetails")
    @ApiOperation("查看员工详情")
    @ApiOperationSupport(order = 5)
    public R<StaffPo> getStaffDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(staffService.getStaffDetails(id));
    }
}
