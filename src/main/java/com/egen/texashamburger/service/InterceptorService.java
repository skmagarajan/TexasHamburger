package com.egen.texashamburger.service;

import com.egen.texashamburger.entity.InterceptorRecorder;

import java.util.List;

public interface InterceptorService {
    void create(InterceptorRecorder interceptorRecorder);
    List<InterceptorRecorder> getAll();
}
