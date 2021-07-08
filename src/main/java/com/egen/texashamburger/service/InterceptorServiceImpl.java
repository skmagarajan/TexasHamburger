package com.egen.texashamburger.service;

import com.egen.texashamburger.entity.InterceptorRecorder;
import com.egen.texashamburger.exception.InterceptorServiceException;
import com.egen.texashamburger.exception.MenuServiceException;
import com.egen.texashamburger.repository.InterceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterceptorServiceImpl implements InterceptorService{

    private InterceptorRepository interceptorRepository;

    @Autowired
    public InterceptorServiceImpl(InterceptorRepository interceptorRepository) {
        this.interceptorRepository = interceptorRepository;
    }

    @Override
    public void create(InterceptorRecorder interceptorRecorder) {
        interceptorRepository.save(interceptorRecorder);
    }

    @Override
    public List<InterceptorRecorder> getAll() {
        try {
            List<InterceptorRecorder> entries = interceptorRepository.findAll();
            return entries;
        } catch (Exception e) {
            throw new InterceptorServiceException("Entries Not Found",e);
        }
    }

    @Override
    public List<InterceptorRecorder> getByControllerName(String controllerName) {
        try {
            List<InterceptorRecorder> entries = interceptorRepository.findAllByAPIContainingIgnoreCase(controllerName);
            return entries;
        } catch (Exception e) {
            throw new InterceptorServiceException("Entries Not Found",e);
        }
    }

    @Override
    public List<InterceptorRecorder> getByDate(String date) {
        try {
            List<InterceptorRecorder> entries = interceptorRepository.findAllByCreatedAtContaining(date);
            return entries;
        } catch (Exception e) {
            throw new InterceptorServiceException("Entries Not Found",e);
        }
    }
}
