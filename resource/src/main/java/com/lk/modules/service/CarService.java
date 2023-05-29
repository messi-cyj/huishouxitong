package com.lk.modules.service;

import com.lk.modules.args.CarSearchArgs;
import com.lk.modules.dto.CarDto;
import com.lk.modules.po.CarPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarService {
    /**
     * 添加车辆
     * @param dto
     * @return
     */
    Boolean saveCar(CarDto dto);

    /**
     * 修改车辆
     * @param dto
     * @return
     */
    Boolean updateCar(CarDto dto);

    /**
     * 删除车辆
     * @param id
     * @return
     */
    Boolean deleteCar(@Param("id") Integer id);

    /**
     * 查看车辆列表
     * @param args
     * @return
     */
    List<CarPo> getCarList(CarSearchArgs args);

    /**
     * 查看车辆详情
     * @param id
     * @return
     */
    CarPo getCarDetails(@Param("id") Integer id);
}
