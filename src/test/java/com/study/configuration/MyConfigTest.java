package com.study.configuration;

import com.study.configuration.entity.MyEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>Title: MyConfigurationTest</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
public class MyConfigTest {
    @Test
    public void testDefaultBeanName() throws Exception {
        System.out.println("默认bean的名称为方法名");
        // 读取配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyEntity entity = (MyEntity) context.getBean("myEntity");
        System.out.println(entity);
    }

    @Test
    public void testCustomBeanName() throws Exception {
        System.out.println("指定bean名称");
        // 读取配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyEntity entity = (MyEntity) context.getBean("myEntityNew");
        System.out.println(entity);
    }

    @Test
    public void testIsSameInstance() {
        System.out.println("判断是否会重复创建bean");
        // 读取配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyEntity entity1 = (MyEntity) context.getBean("myEntity");
        MyEntity entity2 = (MyEntity) context.getBean("myEntity");
        System.out.println(entity1 == entity2);// 打印true
    }

}