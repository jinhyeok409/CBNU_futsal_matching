package com.project.cbnu.dto;

import com.project.cbnu.entity.MatchEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 데이터 베이스 값
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MatchDTO {
    private Integer gamenum;
    private Integer number;
    private String player;
    private Integer playerlevel;
    private String team;
    private Integer playvoted;

    public static MatchDTO toMatchDTO (MatchEntity matchEntity){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setGamenum(matchEntity.getGamenum());
        matchDTO.setNumber(matchEntity.getNumber());
        matchDTO.setPlayer(matchEntity.getPlayer());
        matchDTO.setPlayerlevel(matchEntity.getPlayerlevel());
        matchDTO.setPlayvoted(matchEntity.getPlayvoted());
        matchDTO.setTeam(matchEntity.getTeam());

        return matchDTO;
    }
}