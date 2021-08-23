package com.study.configures.componentscan;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * <p>Title: MyConfigByScanTest</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
public class MyConfigByScanTest {
    @Test
    public void testGetBean() {
        // 读取配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigByScan.class);
        // 打印所有扫描到得bean
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames).replaceAll("\\[|\\]","")
        .replaceAll(",","\n"));
    }
}
