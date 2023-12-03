package com.project.cbnu.service;

import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.entity.MatchEntity;
import com.project.cbnu.entity.MemberEntity;
import com.project.cbnu.repository.MatchRepository;
import com.project.cbnu.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MemberRepository memberRepository;

    public void save(MatchDTO matchDTO) {
        // 1. dto -> entity 변환
        // 2. repository 의 save 메서드 호출
        MatchEntity matchEntity = MatchEntity.toMatchEntity(matchDTO);
        matchRepository.saveAndFlush(matchEntity);
        //repository 의 save 메서드 호출 ( 조건 entity 객체를 넘겨줘야함 )

    }


    public MatchDTO MatchingSubmit(MatchDTO matchDTO, String UserId) {


        Optional<MatchEntity> byPlayer = matchRepository.findByPlayer(UserId);


        if (byPlayer.isPresent()) {
            MatchEntity matchEntity = byPlayer.get();
            if (matchEntity.getGamenum().equals(1)) {
                System.out.println("이미존재");

                MatchDTO dto = MatchDTO.toMatchDTO(matchEntity);
                return dto;

            }
        }


            System.out.println("신규등록");

            return null;


    }
}
