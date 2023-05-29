package com.lk.modules.mapper;

import com.lk.modules.args.CarSearchArgs;
import com.lk.modules.dto.CarDto;
import com.lk.modules.po.CarPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    Boolean saveCar(CarDto dto);

    Boolean updateCar(CarDto dto);

    Boolean deleteCar(Integer id);

    List<CarPo> getCarList(CarSearchArgs args);

    CarPo getCarDetails(Integer id);
}
