package com.lk.modules.controller;

import com.lk.modules.service.StoreService;
import com.lk.modules.entity.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * store
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/store")
@Api(tags = "仓库管理模块")
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 获取所有仓库信息
     *
     * @param pageNum
     * @param pageSize
     * @param store
     * @return
     */

    @GetMapping("/getStoreInfo")
    @ApiOperation("获取所有仓库信息")
    public Result getStoreInfo(Store store, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Store> data = storeService.selectStoreInfo(store, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存仓库信息
     *
     * @param store
     * @return
     */
    @PostMapping("/saveStoreInfo")
    @ApiOperation("保存仓库信息")
    public Result saveStoreInfo(@RequestBody Store store) {
        storeService.saveStoreInfo(store);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新仓库信息
     *
     * @param store
     * @return
     */

    @PutMapping("/updateStoreInfo")
    @ApiOperation("更新仓库信息")
    public Result updateStoreInfo(@RequestBody Store store) {
        storeService.updateStoreInfo(store);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除仓库信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delStoreInfo")
    @ApiOperation("根据id删除仓库信息")
    public Result delStoreInfo(Integer id) {
        storeService.delStoreInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除仓库信息
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchStoreInfo")
    @ApiOperation("根据id集合批量删除仓库信息")
    public Result delBatchStoreInfo(String idList) {
        storeService.delBatchStoreInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}