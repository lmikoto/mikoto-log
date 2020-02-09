package io.github.lmikoto.log.listener;

import io.github.lmikoto.log.model.LogEntity;
import io.github.lmikoto.mikoto.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogSaveEvent implements BaseEvent {

    private LogEntity logEntity;
}