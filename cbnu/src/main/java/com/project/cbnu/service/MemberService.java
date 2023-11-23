package com.project.cbnu.service;

import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.entity.MemberEntity;
import com.project.cbnu.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private  final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2. repository 의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repository 의 save 메서드 호출 ( 조건 entity 객채를 넘겨줘야함 )

    }

    public MemberDTO login (MemberDTO memberDTO){
        /*
        입력한 학번으로 DB조회
        -> 조회 비밀번호와 사용자 입력 비밀번호 맞는지 판단.
        */
        Optional<MemberEntity> byUserId = memberRepository.findByUserid(memberDTO.getUserid());
        if(byUserId.isPresent()){
            // 조회 결과가 있음
            MemberEntity memberEntity = byUserId.get();
            if(memberEntity.getUserpw().equals(memberDTO.getUserpw())){
                // 비밀번호가 DB와 일치
                // entity - dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }
            else {
                return null;
            }
        }
        else {
            //조회 결과가 없음
            return null;
        }
    }
}
