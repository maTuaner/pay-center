package com.hkuo.demo.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author liuch
 * @date 2022/7/15
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    /**
     * 如果希望所有数据源在启动配置时就加载好，这里通过设置数据源Key值来切换数据，定制这个方法
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHelper.get();
    }

}
