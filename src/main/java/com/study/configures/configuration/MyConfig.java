package com.study.configures.configuration;

import com.study.entity.MyEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: MyConfiguration</p>
 * <p>Description: 在配置类中配置Bean</p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
@Configuration
public class MyConfig {
    // 默认bean的名称为方法名，也可以@Bean注解指定名称
    @Bean
    public MyEntity myEntity() {
        return new MyEntity("1","实体1");
    }


    @Bean("myEntityNew")
    public MyEntity myEntity2() {
        return new MyEntity("2","实体2");
    }
}
