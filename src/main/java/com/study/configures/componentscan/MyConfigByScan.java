package com.study.configures.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * <p>Title: MyConfigByScan</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
@Configuration
@ComponentScan(value = "com.study.entity",
//        includeFilters = {@Filter(type= FilterType.ASSIGNABLE_TYPE,value = {MyController.class, MyService.class})}),
//        includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = {Component.class})},
        includeFilters = {@ComponentScan.Filter(type= FilterType.CUSTOM,value = {MyTypeFilter.class})},
        useDefaultFilters = false
)
public class MyConfigByScan {

}
