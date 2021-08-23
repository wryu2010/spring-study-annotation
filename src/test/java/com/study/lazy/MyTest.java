package com.study.lazy;

import com.study.configures.lazy.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>Title: MyTest</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/23
 */
public class MyTest {
    @Test
    public void testLazy() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("--------------IOC容器加载完成-----------");
        context.getBean("myeEntity");
        context.getBean("myLazyEntity");
    }
}
