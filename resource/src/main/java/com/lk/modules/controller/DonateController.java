package com.lk.modules.controller;

import com.lk.modules.service.DonateService;
import com.lk.modules.entity.Donate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * donate
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/donate")
@Api(tags = "捐赠管理模块")
public class DonateController {
    @Autowired
    private DonateService donateService;

    /**
     * 获取所有爱心捐赠
     *
     * @param pageNum
     * @param pageSize
     * @param donate
     * @return
     */

    @GetMapping("/getDonateInfo")
    @ApiOperation("获取所有爱心捐赠")
    public Result getDonateInfo(Donate donate, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Donate> data = donateService.selectDonateInfo(donate, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存爱心捐赠
     *
     * @param donate
     * @return
     */
    @PostMapping("/saveDonateInfo")
    @ApiOperation("保存爱心捐赠")
    public Result saveDonateInfo(@RequestBody Donate donate) {
        donateService.saveDonateInfo(donate);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新爱心捐赠
     *
     * @param donate
     * @return
     */

    @PutMapping("/updateDonateInfo")
    @ApiOperation("更新爱心捐赠")
    public Result updateDonateInfo(@RequestBody Donate donate) {
        donateService.updateDonateInfo(donate);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除爱心捐赠
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delDonateInfo")
    @ApiOperation("根据id删除爱心捐赠")
    public Result delDonateInfo(Integer id) {
        donateService.delDonateInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除爱心捐赠
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchDonateInfo")
    @ApiOperation("根据id集合批量删除爱心捐赠")
    public Result delBatchDonateInfo(String idList) {
        donateService.delBatchDonateInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}