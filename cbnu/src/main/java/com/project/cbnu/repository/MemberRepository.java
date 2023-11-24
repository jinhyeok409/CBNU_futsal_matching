package com.project.cbnu.repository;

import com.project.cbnu.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // 학번으로 회원가입 조회
    Optional<MemberEntity> findByUserid (String userid);
}
