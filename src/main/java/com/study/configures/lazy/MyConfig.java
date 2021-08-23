package com.study.configures.lazy;

import com.study.entity.MyEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * <p>Title: MyConfiguration</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
@Configuration
public class MyConfig {

    @Lazy
    @Bean
    public MyEntity myeEntity() {
        System.out.println("初始化myeEntity");
        return new MyEntity("1","正常实体");
    }

    @Bean
    public MyEntity myLazyEntity() {
        System.out.println("初始化myLazyEntity");
        return new MyEntity("1","懒加载实体");
    }
}
