package com.ms.mybatis.service;

import com.ms.mybatis.Car;
import com.ms.mybatis.CarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public Car getCar(int id) {
        log.info("#### CarService called");
        return carMapper.selectCarById(id);
    }
}
