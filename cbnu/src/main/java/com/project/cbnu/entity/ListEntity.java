package com.project.cbnu.entity;

import com.project.cbnu.dto.ListDTO;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name ="list")

public class ListEntity {


    @Id
    private Integer gamelist;

    @Column
    private Integer min;

    @Column
    private Integer max;

    @Column
    private Integer participant;

    @Column
    private String submitend;

    @Column
    private String votingend;

    @Column
    private String gameend;




    // DTO -> Entity
    public static ListEntity toListEntity(ListDTO listDTO) {
        ListEntity listEntity = new ListEntity();
        listEntity.setGamelist(listDTO.getGamelist());
        listEntity.setMin(listDTO.getMin());
        listEntity.setMax(listDTO.getMax());
        listEntity.setParticipant(listDTO.getParticipant());
        listEntity.setSubmitend(listDTO.getSubmitend());
        listEntity.setVotingend(listDTO.getVotingend());
        listEntity.setGameend(listDTO.getGameend());


        return listEntity;
    }

}
