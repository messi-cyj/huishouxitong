package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.EduYearSearchArgs;
import com.lk.modules.dto.EduYearDto;
import com.lk.modules.po.EduYearPo;
import com.lk.modules.service.EduYearService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import com.lk.modules.vo.EduYearVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/yearEdu")
@Api(tags = "年度资料模块")
public class EduYearController {
    @Autowired
    private EduYearService eduYearService;

    @PostMapping("/saveYearEdu")
    @ApiOperation("添加年度资料")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveYearEdu(@RequestBody EduYearDto dto) {
        return R.ok(eduYearService.saveYearEdu(dto));
    }

    @PutMapping("/updateYearEdu")
    @ApiOperation("修改年度资料")
    @ApiOperationSupport(order = 2)
    public R updateYearEdu(@RequestBody EduYearDto dto) {
        return R.ok(eduYearService.updateYearEdu(dto));
    }

    @DeleteMapping("/deleteYearEdu")
    @ApiOperation("删除年度资料")
    @ApiOperationSupport(order = 3)
    public R deleteYearEdu(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(eduYearService.deleteYearEdu(id));
    }

    @PostMapping("/getYearEduList")
    @ApiOperation("查看年度资料列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<EduYearVo>> getYearEduList(@RequestBody EduYearSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<EduYearVo> list = eduYearService.getYearEduList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getYearEduDetails")
    @ApiOperation("查看年度资料详情")
    @ApiOperationSupport(order = 5)
    public R<EduYearPo> getYearEduDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(eduYearService.getYearEduDetails(id));
    }
}
