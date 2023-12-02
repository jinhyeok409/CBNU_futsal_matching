package com.project.cbnu.repository;

import com.project.cbnu.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<MatchEntity, Integer> {
    // 학번으로 회원가입 조회
    Optional<MatchEntity> findByGamenum (Integer gamenum);
}