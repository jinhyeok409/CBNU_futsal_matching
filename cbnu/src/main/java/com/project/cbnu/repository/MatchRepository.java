package com.project.cbnu.repository;

import com.project.cbnu.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<MatchEntity, Integer> {
    // Number로 Matching DB 탐색
    Optional<MatchEntity> findByNumber (Integer number);
    Optional<MatchEntity> findByPlayer (String player);
}