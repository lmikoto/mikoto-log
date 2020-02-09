package io.github.lmikoto.log.model;

import io.github.lmikoto.jpa.entity.BaseEntity;
import io.github.lmikoto.log.enums.LogType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mikoto_log")
@Data
public class LogEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private LogType logType;

    private String request;

    private String response;

    private String methodName;

    private String className;

    private Date callStartAt;

    private Date callEndAt;

    private Long elapsed;
}
