package com.hkuo.demo.config.db;

import java.lang.annotation.*;

/**
 * @author liuch
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface DataSource {
    DataSourceEnum value() default DataSourceEnum.SLAVE;
}
