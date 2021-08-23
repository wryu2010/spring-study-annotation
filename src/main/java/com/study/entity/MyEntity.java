package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * <p>Title: MyEntity</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
@Data
@ToString
@AllArgsConstructor
public class MyEntity {
    private String id;
    private String desc;
}
