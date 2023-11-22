package com.project.cbnu.service;

import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.entity.MemberEntity;
import com.project.cbnu.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class MemberService {

    private  final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity
        // 2. repository 의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repository 의 save 메서드 호출 ( 조건 entity 객채를 넘겨줘야함 )

    }
}
