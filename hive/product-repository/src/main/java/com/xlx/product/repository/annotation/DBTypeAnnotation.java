package com.xlx.product.repository.annotation;

import com.xlx.product.repository.config.DBType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 放置在方法上的注解, 用来指定使用的数据源类型, 默认使用主数据源
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBTypeAnnotation {

    @AliasFor("values")
    DBType dbType() default DBType.MASTER;

    @AliasFor("dbType")
    DBType values() default DBType.MASTER;
}
