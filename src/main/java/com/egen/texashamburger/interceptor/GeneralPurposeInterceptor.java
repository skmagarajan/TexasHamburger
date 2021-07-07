package com.egen.texashamburger.interceptor;

import com.egen.texashamburger.entity.InterceptorRecorder;
import com.egen.texashamburger.service.InterceptorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Component
public class GeneralPurposeInterceptor implements HandlerInterceptor {

    private final Logger Log = LoggerFactory.getLogger(GeneralPurposeInterceptor.class);
    LocalDateTime start,end;
    InterceptorRecorder interceptorRecorder;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    private InterceptorService interceptorService;

    @Autowired
    public GeneralPurposeInterceptor(InterceptorService interceptorService){
        this.interceptorService = interceptorService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        start = LocalDateTime.now();
        interceptorRecorder = new InterceptorRecorder();
        interceptorRecorder.setAPI(handler.toString());
        interceptorRecorder.setStartTime(start.format(formatter));
        Log.info("Inside PreHandle: "+start);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        end = LocalDateTime.now();
        interceptorRecorder.setEndTime(end.format(formatter));
        Log.info("Inside PostHandle: "+end);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(end!=null && handler.toString().contains("controller")){
            long diff = end.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                    - start.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            interceptorRecorder.setTimeTaken_ms(diff);
            Log.info("After Completion: "+diff+":"+interceptorService);
            interceptorService.create(interceptorRecorder);
        }
        // Clean Start and End time
        start = null;
        end = null;
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
