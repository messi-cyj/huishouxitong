package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.EduMonthSearchArgs;
import com.lk.modules.dto.EduMonthDto;
import com.lk.modules.po.EduMonthPo;
import com.lk.modules.service.EduMonthService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import com.lk.modules.vo.EduMonthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/monthEdu")
@Api(tags = "月度资料模块")
public class EduMonthController {
    @Autowired
    private EduMonthService eduMonthService;

    @PostMapping("/saveMonthEdu")
    @ApiOperation("添加月度资料")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveMonthEdu(@RequestBody EduMonthDto dto) {
        return R.ok(eduMonthService.saveMonthEdu(dto));
    }

    @PutMapping("/updateMonthEdu")
    @ApiOperation("修改月度资料")
    @ApiOperationSupport(order = 2)
    public R updateMonthEdu(@RequestBody EduMonthDto dto) {
        return R.ok(eduMonthService.updateMonthEdu(dto));
    }

    @DeleteMapping("/deleteMonthEdu")
    @ApiOperation("删除月度资料")
    @ApiOperationSupport(order = 3)
    public R deleteMonthEdu(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(eduMonthService.deleteMonthEdu(id));
    }

    @PostMapping("/getMonthEduList")
    @ApiOperation("查看月度资料列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<EduMonthVo>> getMonthEduList(@RequestBody EduMonthSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<EduMonthVo> list = eduMonthService.getMonthEduList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getMonthEduDetails")
    @ApiOperation("查看月度资料详情")
    @ApiOperationSupport(order = 5)
    public R<EduMonthPo> getMonthEduDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(eduMonthService.getMonthEduDetails(id));
    }
}
