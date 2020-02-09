package io.github.lmikoto.log.service;

import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import io.github.lmikoto.log.config.LogConfigs;
import io.github.lmikoto.log.interfaces.Process;
import io.github.lmikoto.log.listener.LogSaveEvent;
import io.github.lmikoto.log.model.LogEntity;
import io.github.lmikoto.mikoto.event.EventBusUtils;
import io.github.lmikoto.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LogService {

    @Autowired
    private LogConfigs logConfig;

    public Object dealLog(LogEntity logEntity, Process process) throws Throwable {
        Stopwatch stopWatch =  Stopwatch.createStarted();
        Object result = null;
        try {
            logEntity.setCallStartAt(new Date());
            result = process.invoke();
        } catch (Exception e) {
            log.error(Throwables.getStackTraceAsString(e));
            throw e;
        } finally {
            stopWatch.stop();
            if(logConfig.getDbEnable()){
                logEntity.setCallEndAt(new Date());
                logEntity.setElapsed(stopWatch.elapsed(TimeUnit.MILLISECONDS));
                logEntity.setResponse(JacksonUtils.toJson(result));
                EventBusUtils.submit(LogSaveEvent.builder().logEntity(logEntity).build());
            }
        }
        return result;
    }

}

