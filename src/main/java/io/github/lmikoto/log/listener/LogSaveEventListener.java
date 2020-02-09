package io.github.lmikoto.log.listener;


import io.github.lmikoto.log.repo.LogRepo;
import io.github.lmikoto.mikoto.event.EventAdapter;
import io.github.lmikoto.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogSaveEventListener extends EventAdapter<LogSaveEvent> {

    @Autowired
    private LogRepo logRepo;

    @Override
    public boolean process(LogSaveEvent logSaveEvent) {
        try {
            logRepo.save(logSaveEvent.getLogEntity());
        }catch (Exception e){
            log.error("save log error {} {}", JacksonUtils.toJson(logSaveEvent),e.getMessage());
        }
        return true;
    }
}
