package com.lk.modules.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.args.CarSearchArgs;
import com.lk.modules.dto.CarDto;
import com.lk.modules.po.CarPo;
import com.lk.modules.service.CarService;
import com.lk.modules.utils.R;
import com.lk.modules.utils.RPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/car")
@Api(tags = "车辆管理模块")
public class CarController {
    @Autowired
    private CarService CarService;

    @PostMapping("/saveCar")
    @ApiOperation("添加车辆")
    @ApiOperationSupport(order = 1, ignoreParameters = {"id"})
    public R saveCar(@RequestBody CarDto dto) {
        return R.ok(CarService.saveCar(dto));
    }

    @PutMapping("/updateCar")
    @ApiOperation("修改车辆")
    @ApiOperationSupport(order = 2)
    public R updateCar(@RequestBody CarDto dto) {
        return R.ok(CarService.updateCar(dto));
    }

    @DeleteMapping("/deleteCar")
    @ApiOperation("删除车辆")
    @ApiOperationSupport(order = 3)
    public R deleteCar(@ApiParam("id") @RequestParam("id") Integer id) {
        return R.ok(CarService.deleteCar(id));
    }

    @PostMapping("/getCarList")
    @ApiOperation("查看车辆列表")
    @ApiOperationSupport(order = 4)
    public RPage<List<CarPo>> getCarList(@RequestBody CarSearchArgs args) {
        final Page<List<Object>> page = PageHelper.startPage(args.getPage(),args.getLimit(),args.getOrder());
        List<CarPo> list = CarService.getCarList(args);
        return RPage.ok(list,args.getPage(),args.getLimit(),page.getTotal());
    }

    @GetMapping("/getCarDetails")
    @ApiOperation("查看车辆详情")
    @ApiOperationSupport(order = 5)
    public R<CarPo> getCarDetails(@ApiParam("id") @RequestParam("id") Integer id){
        return R.ok(CarService.getCarDetails(id));
    }
}
