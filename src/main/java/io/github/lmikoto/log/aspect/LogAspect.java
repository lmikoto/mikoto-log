package io.github.lmikoto.log.aspect;

import io.github.lmikoto.log.annotation.Log;
import io.github.lmikoto.log.consts.Constant;
import io.github.lmikoto.log.model.LogEntity;
import io.github.lmikoto.log.service.LogService;
import io.github.lmikoto.log.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
@Aspect
@Order(Constant.ORDER)
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(io.github.lmikoto.log.annotation.Log)")
    public void log(){
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) (joinPoint.getSignature());
        Method method = joinPoint.getTarget().getClass().getDeclaredMethod(methodSignature.getName(),
                methodSignature.getMethod().getParameterTypes());
        Log logAnnotation = method.getAnnotation(Log.class);
        LogEntity logEntity = new LogEntity();
        logEntity.setRequest(LogUtils.getRequestParam(joinPoint));
        logEntity.setLogType(logAnnotation.logType());
        logEntity.setMethodName(method.getName());
        logEntity.setClassName(method.getDeclaringClass().getName());
        return logService.dealLog(logEntity, () -> joinPoint.proceed());
    }

}
