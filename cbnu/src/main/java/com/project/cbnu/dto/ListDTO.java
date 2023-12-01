package com.project.cbnu.dto;

import com.project.cbnu.entity.ListEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 데이터 베이스 값
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ListDTO {

    private Integer gamelist;
    private Integer min;
    private Integer max;
    private Integer participant;
    private String submitend;
    private String votingend;
    private String gameend;

    public static ListDTO toListDTO (ListEntity listEntity){
        ListDTO listDTO = new ListDTO();
        listDTO.setGamelist(listEntity.getGamelist());
        listDTO.setMin(listEntity.getMin());
        listDTO.setMin(listEntity.getMax());
       listDTO.setParticipant(listEntity.getParticipant());
        listDTO.setSubmitend(listEntity.getSubmitend());
        listDTO.setVotingend(listEntity.getVotingend());
        listDTO.setGameend(listEntity.getGameend());

        return listDTO;
    }
}
