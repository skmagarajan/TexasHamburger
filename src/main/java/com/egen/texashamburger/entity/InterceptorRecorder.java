package com.egen.texashamburger.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "apirecorder")
public class InterceptorRecorder {
    @Id
    private String Id;

    private String API;
    private String startTime;
    private String endTime;
    private Long timeTaken_ms;
    private String createdAt;


    public InterceptorRecorder(){
        this.Id = UUID.randomUUID().toString();
        this.createdAt = String.valueOf(LocalDateTime.now());
    }
}
