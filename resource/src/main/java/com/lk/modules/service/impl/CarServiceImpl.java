package com.lk.modules.service.impl;

import com.lk.modules.args.CarSearchArgs;
import com.lk.modules.dto.CarDto;
import com.lk.modules.mapper.CarMapper;
import com.lk.modules.po.CarPo;
import com.lk.modules.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public Boolean saveCar(CarDto dto) {
        return carMapper.saveCar(dto);
    }

    @Override
    public Boolean updateCar(CarDto dto) {
        return carMapper.updateCar(dto);
    }

    @Override
    public Boolean deleteCar(Integer id) {
        return carMapper.deleteCar(id);
    }

    @Override
    public List<CarPo> getCarList(CarSearchArgs args) {
        return carMapper.getCarList(args);
    }

    @Override
    public CarPo getCarDetails(Integer id) {
        return carMapper.getCarDetails(id);
    }
}
