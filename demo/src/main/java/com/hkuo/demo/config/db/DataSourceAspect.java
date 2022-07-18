package com.hkuo.demo.config.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源处理
 *
 * @author liuch
 * @date 2022/7/15
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.hkuo.demo.config.db.DataSource)")
    public void dsPointCut() {}

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);

        if (null != dataSource) {
            DynamicDataSourceHelper.set(dataSource.value());
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceHelper.remove();
        }
    }
}
