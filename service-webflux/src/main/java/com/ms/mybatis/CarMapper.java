package com.ms.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CarMapper {

    @Select("SELECT id, name FROM car WHERE id = #{id}")
    Car selectCarById(int id);
}
