package com.egen.texashamburger.controller;

import com.egen.texashamburger.entity.InterceptorRecorder;
import com.egen.texashamburger.response.Response;
import com.egen.texashamburger.response.ResponseMetadata;
import com.egen.texashamburger.response.StatusMessage;
import com.egen.texashamburger.service.InterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/time")
public class ExecutionTimeController {

    private InterceptorService interceptorService;

    @Autowired
    public ExecutionTimeController(InterceptorService interceptorService){
        this.interceptorService = interceptorService;
    }

    @GetMapping("/getAll")
    public Response<List<InterceptorRecorder>> getAll(){
        return Response.<List<InterceptorRecorder>>builder()
                .meta(ResponseMetadata.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((interceptorService.getAll()))
                .build();
    }
}
