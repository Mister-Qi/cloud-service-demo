package com.ms.mybatis.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyBatisMapperBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(CarMapperFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(CarMapper.class);
//        registry.registerBeanDefinition("carMapper", beanDefinition);

        // use custom scanner to scan the mappers
        String scanPath = "com.ms.mybatis";

        MyBatisMapperScanner scanner = new MyBatisMapperScanner(registry);
        int scan = scanner.scan(scanPath);
        log.info("scanned :: {}", scan);
    }
}
