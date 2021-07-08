package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.InterceptorRecorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterceptorRepository extends JpaRepository<InterceptorRecorder,String> {
    List<InterceptorRecorder> findAllByAPIContainingIgnoreCase(String controllerName);
    List<InterceptorRecorder> findAllByCreatedAtContaining(String date);
}
