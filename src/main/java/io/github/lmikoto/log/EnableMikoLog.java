package io.github.lmikoto.log;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogConfig.class)
public @interface EnableMikoLog {
}
