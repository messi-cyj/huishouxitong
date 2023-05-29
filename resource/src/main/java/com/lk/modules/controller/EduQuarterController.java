package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.EduQuarterSearchArgs;
import com.lk.modules.dto.EduQuarterDto;
import com.lk.modules.po.EduQuarterPo;
import com.lk.modules.service.EduQuarterService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import com.lk.modules.vo.EduQuarterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/quarterEdu")
@Api(tags = "季度资料模块")
public class EduQuarterController {
    @Autowired
    private EduQuarterService eduQuarterService;

    @PostMapping("/saveQuarterEdu")
    @ApiOperation("添加季度资料")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveQuarterEdu(@RequestBody EduQuarterDto dto) {
        return R.ok(eduQuarterService.saveQuarterEdu(dto));
    }

    @PutMapping("/updateQuarterEdu")
    @ApiOperation("修改季度资料")
    @ApiOperationSupport(order = 2)
    public R updateQuarterEdu(@RequestBody EduQuarterDto dto) {
        return R.ok(eduQuarterService.updateQuarterEdu(dto));
    }

    @DeleteMapping("/deleteQuarterEdu")
    @ApiOperation("删除季度资料")
    @ApiOperationSupport(order = 3)
    public R deleteQuarterEdu(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(eduQuarterService.deleteQuarterEdu(id));
    }

    @PostMapping("/getQuarterEduList")
    @ApiOperation("查看季度资料列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<EduQuarterVo>> getQuarterEduList(@RequestBody EduQuarterSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<EduQuarterVo> list = eduQuarterService.getQuarterEduList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getQuarterEduDetails")
    @ApiOperation("查看季度资料详情")
    @ApiOperationSupport(order = 5)
    public R<EduQuarterPo> getQuarterEduDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(eduQuarterService.getQuarterEduDetails(id));
    }
}
