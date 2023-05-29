package com.lk.modules.controller;

import com.lk.modules.service.LifeService;
import com.lk.modules.entity.Life;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * life
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/life")
@Api(tags = "生活管理模块")
public class LifeController {
    @Autowired
    private LifeService lifeService;

    /**
     * 获取所有生活服务
     *
     * @param pageNum
     * @param pageSize
     * @param life
     * @return
     */

    @GetMapping("/getLifeInfo")
    @ApiOperation("获取所有生活服务")
    public Result getLifeInfo(Life life, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Life> data = lifeService.selectLifeInfo(life, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存生活服务
     *
     * @param life
     * @return
     */
    @PostMapping("/saveLifeInfo")
    @ApiOperation("保存生活服务")
    public Result saveLifeInfo(@RequestBody Life life) {
        lifeService.saveLifeInfo(life);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新生活服务
     *
     * @param life
     * @return
     */

    @PutMapping("/updateLifeInfo")
    @ApiOperation("更新生活服务")
    public Result updateLifeInfo(@RequestBody Life life) {
        lifeService.updateLifeInfo(life);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除生活服务
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delLifeInfo")
    @ApiOperation("根据id删除生活服务")
    public Result delLifeInfo(Integer id) {
        lifeService.delLifeInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除生活服务
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchLifeInfo")
    @ApiOperation("根据id集合批量删除生活服务")
    public Result delBatchLifeInfo(String idList) {
        lifeService.delBatchLifeInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}