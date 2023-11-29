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
    //private Integer id;
    private Integer gamenum;
    private Date date;
    private String player;
    private Integer playerlevel;
    private String team;
    private Integer playvoted;

    public static MatchDTO toMatchDTO (MatchEntity matchEntity){
        MatchDTO matchDTO = new MatchDTO();
//      matchDTO.setId(MatchEntity.getId());
        matchDTO.setGamenum(matchEntity.getGamenum());
        matchDTO.setDate(matchEntity.getDate());
        matchDTO.setPlayer(matchEntity.getPlayer());
        matchDTO.setPlayerlevel(matchEntity.getPlayerlevel());
        matchDTO.setPlayvoted(matchEntity.getPlayvoted());
        matchDTO.setTeam(matchEntity.getTeam());

        return matchDTO;
    }
}