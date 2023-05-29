package com.lk.modules.controller;

import com.lk.modules.service.ProductService;
import com.lk.modules.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * product
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/product")
@Api(tags = "回收管理模块")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 获取所有回收物
     *
     * @param pageNum
     * @param pageSize
     * @param product
     * @return
     */

    @GetMapping("/getProductInfo")
    @ApiOperation("获取所有回收物")
    public Result getProductInfo(Product product, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Product> data = productService.selectProductInfo(product, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存回收物
     *
     * @param product
     * @return
     */
    @PostMapping("/saveProductInfo")
    @ApiOperation("保存回收物")
    public Result saveProductInfo(@RequestBody Product product) {
        productService.saveProductInfo(product);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新回收物
     *
     * @param product
     * @return
     */

    @PutMapping("/updateProductInfo")
    @ApiOperation("更新回收物")
    public Result updateProductInfo(@RequestBody Product product) {
        productService.updateProductInfo(product);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除回收物
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delProductInfo")
    @ApiOperation("根据id删除回收物")
    public Result delProductInfo(Integer id) {
        productService.delProductInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除回收物
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchProductInfo")
    @ApiOperation("根据id集合批量删除回收物")
    public Result delBatchProductInfo(String idList) {
        productService.delBatchProductInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}