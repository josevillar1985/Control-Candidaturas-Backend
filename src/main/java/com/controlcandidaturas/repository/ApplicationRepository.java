package com.controlcandidaturas.repository;

import com.controlcandidaturas.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository <Application, Long> {
}
