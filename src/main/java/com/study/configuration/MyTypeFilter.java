package com.study.configuration;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * <p>Title: MyTypeFilter</p>
 * <p>Description: </p>
 *
 * @author wenrongyu
 * @date 2021/08/22
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前扫描到的所有类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 自定义扫描逻辑，只扫描类名包含controller的类
        String className = classMetadata.getClassName();

        if (className.contains("Controller")) {
            return true;
        }

        return false;
    }
}
