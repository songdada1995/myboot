package com.spbt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop拦截所有controller层，对某些特定dao进行判断，并切换数据源
 * @author songbo
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.spbt..*.*(..))")
    public void declareJointPointExpression() {}

    /**
     * 使用定义切点表达式的方法进行切点表达式的引入
     */
    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point) {

    }

}
