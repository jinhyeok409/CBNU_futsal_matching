package com.project.cbnu.service;

import com.project.cbnu.dto.ListDTO;
import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.entity.ListEntity;
import com.project.cbnu.entity.MatchEntity;
import com.project.cbnu.repository.ListRepository;
import com.project.cbnu.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListService {

    private final ListRepository listRepository;
    private final MatchRepository matchRepository;

    public void save(ListDTO listDTO) {

        // 1. dto -> entity 변환
        // 2. repository 의 save 메서드 호출
        ListEntity listEntity = ListEntity.toListEntity(listDTO);
        listRepository.saveAndFlush(listEntity);


        //repository 의 save 메서드 호출 ( 조건 entity 객체를 넘겨줘야함 )

    }

    public ListDTO ListLoad(Integer MatchNumber) {

    Optional<ListEntity> byGamelist = listRepository.findByGamelist(MatchNumber);

    ListEntity listEntity = byGamelist.get();

    ListDTO dto = ListDTO.toListDTO(listEntity);
    return dto;

    }






}
