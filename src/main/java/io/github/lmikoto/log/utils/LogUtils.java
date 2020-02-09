package io.github.lmikoto.log.utils;

import io.github.lmikoto.utils.JacksonUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Parameter;

public class LogUtils {

    /**
     * 获取请求参数
     *
     * @param point
     *
     * @return
     */
    public static String getRequestParam(ProceedingJoinPoint point){
        Object[] methodArgs = point.getArgs();
        Parameter[] parameters = ((MethodSignature) point.getSignature()).getMethod().getParameters();
        String requestStr;
        try {
            requestStr = logParam(parameters, methodArgs);
        } catch (Exception e) {
            requestStr = "获取参数失败";
        }
        return requestStr;
    }

    /**
     * 拼接请求参数
     *
     * @param paramsArgsName
     * @param paramsArgsValue
     *
     * @return
     */
    private static String logParam(Parameter[] paramsArgsName, Object[] paramsArgsValue){
        if (ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < paramsArgsValue.length; i++) {
            //参数名
            String name = paramsArgsName[i].getName();
            //参数值
            Object value = paramsArgsValue[i];
            buffer.append(name + "=");
            if (value instanceof String) {
                buffer.append(value + ",");
            } else {
                buffer.append(JacksonUtils.toJson(value) + ",");
            }
        }
        return buffer.toString();
    }
}
