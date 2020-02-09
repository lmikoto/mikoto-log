package io.github.lmikoto.log.annotation;

import io.github.lmikoto.log.enums.LogType;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 接口描述
     * @return
     */
    String desc() default "";

    LogType logType() default LogType.SERVICE;
}
