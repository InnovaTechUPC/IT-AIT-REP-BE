package com.assignit.coreservice.ai.dao;

import com.assignit.coreservice.ai.model.Ai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AiDAO extends JpaRepository<Ai, Long> {

}
