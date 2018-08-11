package com.huangpeng.cloud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <pre>
 * 任务：
 * 描述：使用aop监控sql执行，打印sql语句和执行时间
 * 作者：@author huangpeng
 * 时间：@create 2018-07-26 下午9:14
 * 类名: MapperAspect
 * </pre>
 **/
@Aspect
@Component
public class MapperAspect {
    private static final Logger logger = LoggerFactory.getLogger(MapperAspect.class);

    @AfterReturning("execution(* com.huangpeng.cloud.mybatisExample..*Mapper.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        logger.info("Completed: " + joinPoint);
    }

    @Pointcut("execution(* com.huangpeng.cloud.mybatisExample..*Mapper.*(..))")
    private void pointCutMethod(){

    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.nanoTime();
        Object obj = pjp.proceed();
        long end = System.nanoTime();
        logger.info("调用Mapper方法：{},参数：{},执行耗时：{}纳秒,耗时：{}毫秒",
                pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()),
                (end - begin),(end - begin) / 1000000);
        return obj;
    }

}
