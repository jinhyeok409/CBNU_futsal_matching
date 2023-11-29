package com.project.cbnu.service;

import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.entity.MatchEntity;
import com.project.cbnu.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public void save(MatchDTO matchDTO) {
        // 1. dto -> entity 변환
        // 2. repository 의 save 메서드 호출
        MatchEntity matchEntity = MatchEntity.toMatchEntity(matchDTO);
        matchRepository.saveAndFlush(matchEntity);
        //repository 의 save 메서드 호출 ( 조건 entity 객체를 넘겨줘야함 )

    }



}