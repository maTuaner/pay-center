package com.hkuo.demo.config.db;

/**
 * @author liuch
 * @date 2022/7/15
 */
public class DynamicDataSourceHelper {
    private static final ThreadLocal<DataSourceEnum> DYNAMIC_DADA_LOCAL = new ThreadLocal<>();

    /**
     * 默认写库
     */
    public static void master() {
        set(DataSourceEnum.MASTER);
    }

    public static void set(DataSourceEnum dbType) {
        DYNAMIC_DADA_LOCAL.set(dbType);
    }

    public static DataSourceEnum get() {
        return DYNAMIC_DADA_LOCAL.get();
    }

    public static void remove() {
        DYNAMIC_DADA_LOCAL.remove();
    }
}
