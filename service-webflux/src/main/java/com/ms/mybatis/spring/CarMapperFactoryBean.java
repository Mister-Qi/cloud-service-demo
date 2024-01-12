package com.ms.mybatis.spring;

import com.ms.mybatis.CarMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

public class CarMapperFactoryBean implements FactoryBean<CarMapper> {
    private final SqlSession sqlSession;

    public CarMapperFactoryBean(SqlSessionFactory sqlSessionFactory) {
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public CarMapper getObject() {
        return sqlSession.getMapper(CarMapper.class);
    }

    @Override
    public Class<?> getObjectType() {
        return CarMapper.class;
    }
}
