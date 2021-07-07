package com.egen.texashamburger.service;

import com.egen.texashamburger.entity.InterceptorRecorder;
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
            throw new MenuServiceException("Entries Not Found",e);
        }
    }
}
