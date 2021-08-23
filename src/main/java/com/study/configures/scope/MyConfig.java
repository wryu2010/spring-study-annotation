package com.study.configures.scope;

import com.study.entity.MyEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>Title: MyConfiguration</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
@Configuration
public class MyConfig {

    @Scope("prototype")
    @Bean
    public MyEntity myPrototypeEntity() {
        return new MyEntity("1","原型实体");
    }

    @Bean
    public MyEntity mySingletonEntity() {
        return new MyEntity("1","单例实体");
    }
}
