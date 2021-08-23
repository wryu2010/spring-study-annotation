package com.study.configures.scope;

import com.study.entity.MyEntity;
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
    public void testScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("作用域为prototype");
        MyEntity myPrototypeEntity1 = (MyEntity) context.getBean("myPrototypeEntity");
        MyEntity myPrototypeEntity2 = (MyEntity) context.getBean("myPrototypeEntity");
        System.out.println(myPrototypeEntity1 == myPrototypeEntity2);

        System.out.println("作用域为singleton");
        MyEntity mySingletonEntity1 = (MyEntity) context.getBean("mySingletonEntity");
        MyEntity mySingletonEntity2  = (MyEntity) context.getBean("mySingletonEntity");
        System.out.println(mySingletonEntity1 == mySingletonEntity2);
    }
}
