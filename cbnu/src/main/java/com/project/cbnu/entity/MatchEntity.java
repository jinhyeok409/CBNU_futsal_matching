package com.project.cbnu.entity;

import com.project.cbnu.dto.MatchDTO;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

// import java.util.Date;

@Entity
@Setter
@Getter
@Table(name ="matching")

public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @Column
    private Integer gamenum;

    @Column
    private String player;

    @Column
    private Integer playerlevel;

    @Column
    private String team;

    @Column
    private Integer playvoted;


    // DTO -> Entity
    public static MatchEntity toMatchEntity(MatchDTO matchDTO) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setGamenum(matchDTO.getGamenum());
        matchEntity.setNumber(matchDTO.getNumber());
        matchEntity.setPlayer(matchDTO.getPlayer());
        matchEntity.setPlayerlevel(matchDTO.getPlayerlevel());
        matchEntity.setTeam(matchDTO.getTeam());
        matchEntity.setPlayvoted(matchDTO.getPlayvoted());


        return matchEntity;
    }

}