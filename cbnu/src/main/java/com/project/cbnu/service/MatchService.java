package com.project.cbnu.service;

import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.entity.MatchEntity;
import com.project.cbnu.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    //
    public List<MatchDTO> getAllPlayersForMatch(Integer matchNumber) {
        List<MatchEntity> playersEntities = matchRepository.findByGamenum(matchNumber);
        return playersEntities.stream()
                .map(MatchDTO::toMatchDTO)
                .collect(Collectors.toList());
    }

    public MatchDTO MatchingSubmit(String UserId, Integer MatchNumber) {

        Optional<MatchEntity> byPlayer = matchRepository.findByPlayer(UserId);

        if (byPlayer.isPresent()) {

            MatchEntity matchEntity = byPlayer.get();
            if (matchEntity.getGamenum() == MatchNumber) {

                MatchDTO dto = MatchDTO.toMatchDTO(matchEntity);
                return dto;
            }
        }

            return null;


    }
    public MatchDTO AlreadyPresent(String UserId, Integer MatchNumber) {

        Optional<MatchEntity> byPlayer = matchRepository.findByPlayer(UserId);

        if (byPlayer.isPresent()) {
            for (int i=1; i <5; i++){
                MatchEntity matchEntity = byPlayer.get();
                if (matchEntity.getGamenum().equals(i)) {

                    MatchDTO dto = MatchDTO.toMatchDTO(matchEntity);
                    return dto;

                }

            }


        }

        return null;

    }

    public MatchDTO VotingParticipant(Integer i, Integer MatchNumber) {

        Optional<MatchEntity> byNumber = matchRepository.findByNumber(i);

        if (byNumber.isPresent()) {

            MatchEntity matchEntity = byNumber.get();
            if (matchEntity.getGamenum() == MatchNumber) {

                MatchDTO dto = MatchDTO.toMatchDTO(matchEntity);
                return dto;
            }
        }

        return null;

    }



}
