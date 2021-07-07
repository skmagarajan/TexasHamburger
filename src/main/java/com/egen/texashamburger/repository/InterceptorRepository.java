package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.InterceptorRecorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterceptorRepository extends JpaRepository<InterceptorRecorder,String> {

}
