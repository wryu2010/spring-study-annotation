[TOC]

该项目用于记录如何使用Spring注解，以便回顾和学习，以下内容均基于Spring **5.0.2.RELEASE**版本。



# Pom文件引入依赖

```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>servlet-api</artifactId>
  <version>2.4</version>
  <scope>provided</scope>
</dependency>

<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.0.2.RELEASE</version>
</dependency>

<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.11</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.12</version>
  <scope>provided</scope>
</dependency>
```



# 常用注解

## 配置型组件

### @Configuration

* 配置类

  ```java
  // 配置类
  @Configuration
  public class MyConfiguration {
      @Bean
      public MyEntity myEntity() {
          return new MyEntity("1","实体1");
      }
  
      @Bean("myEntityNew")
      public MyEntity myEntity2() {
          return new MyEntity("2","实体2");
      }
  }
  ```

  > ***bean的名称默认为方法名，可以通过@Bean指定bean的名称。虽然是用new创建了对象，但是Spring会返回的是一个单例。***



* 测试

  ```java
  public class MyConfigurationTest {
      @Test
      public void myEntity() throws Exception {
          System.out.println("默认bean的名称为方法名");
          // 读取配置类
          ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
          MyEntity entity = (MyEntity) context.getBean("myEntity");
          System.out.println(entity);// 打印MyEntity(id=1, desc=实体1)
      }
  
      @Test
      public void myEntity2() throws Exception {
          System.out.println("指定bean名称");
          // 读取配置类
          ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
          MyEntity entity = (MyEntity) context.getBean("myEntityNew");
          System.out.println(entity);// 打印MyEntity(id=2, desc=实体2)
      }
      
      @Test
      public void testIsSameInstance() {
          System.out.println("判断是否会重复创建bean");
          // 读取配置类
          ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
          MyEntity entity1 = (MyEntity) context.getBean("myEntity");
          MyEntity entity2 = (MyEntity) context.getBean("myEntity");
          System.out.println(entity1 == entity2);// 打印true
      }
  
  }
  ```



## @ComponentScan

* 配置类

  ```java
  @Configuration
  @ComponentScan(value = "com.study.configuration.entity",
          includeFilters = {@Filter(type= FilterType.ANNOTATION,value = {Component.class})})
  public class MyConfigByScan {
  
  }
  ```

  > @ComponentScan需要配置includeFilters来指定扫描规则，否则不会扫描目标包下的bean。可以通过以下几种方式指定扫描规则：
  >
  > 1. 注解，因为@Controller、@Service、@Repository是@Component的子类，因此这里value只需要写Component.class即可
  >
  >    ```java
  >    includeFilters = {@Filter(type= FilterType.ANNOTATION,
  >                              value = {Component.class})})
  >    ```
  >
  >    
  >
  > 2. 类型
  >
  >    ```java
  >    includeFilters = {@Filter(type= FilterType.ASSIGNABLE_TYPE,
  >                              value = {MyController.class, MyService.class})})
  >    ```
  >
  >    
  >
  > 3. 切面
  >
  > 4. 正则
  >
  > 5. 自定义
  >
  >    ```java
  >    includeFilters = {@Filter(type= FilterType.ASSIGNABLE_TYPE,
  >                              value = {MyController.class, MyService.class})}
  >    useDefaultFilters = false)
  >    ```
  >
  >    ```java
  >    public class MyTypeFilter implements TypeFilter {
  >        @Override
  >        public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
  >            // 获取当前扫描到的所有类的信息
  >            ClassMetadata classMetadata = metadataReader.getClassMetadata();
  >    
  >            // 自定义扫描逻辑，只扫描类名包含controller的类
  >            String className = classMetadata.getClassName();
  >            if (className.contains("Controller")) {
  >                return true;
  >            }
  >    
  >            return false;
  >        }
  >    }
  >    ```

  

* 测试

  ```java
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
  ```

  

