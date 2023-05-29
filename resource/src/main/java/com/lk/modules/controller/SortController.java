package com.lk.modules.controller;

import com.lk.modules.service.SortService;
import com.lk.modules.entity.Sort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * sort
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/sort")
@Api(tags = "分类管理模块")
public class SortController {
    @Autowired
    private SortService sortService;

    /**
     * 获取所有分类信息
     *
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */

    @GetMapping("/getSortInfo")
    @ApiOperation("获取所有分类信息")
    public Result getSortInfo(Sort sort, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Sort> data = sortService.selectSortInfo(sort, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存分类信息
     *
     * @param sort
     * @return
     */
    @PostMapping("/saveSortInfo")
    @ApiOperation("保存分类信息")
    public Result saveSortInfo(@RequestBody Sort sort) {
        sortService.saveSortInfo(sort);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新分类信息
     *
     * @param sort
     * @return
     */

    @PutMapping("/updateSortInfo")
    @ApiOperation("更新分类信息")
    public Result updateSortInfo(@RequestBody Sort sort) {
        sortService.updateSortInfo(sort);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除分类信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delSortInfo")
    @ApiOperation("根据id删除分类信息")
    public Result delSortInfo(Integer id) {
        sortService.delSortInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除分类信息
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchSortInfo")
    @ApiOperation("根据id集合批量删除分类信息")
    public Result delBatchSortInfo(String idList) {
        sortService.delBatchSortInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}