package com.project.cbnu.dto;

import com.project.cbnu.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 데이터 베이스 값
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    //private Integer id;
    private String userid;
    private String userpw;
    private String username;
    private Integer userlevel;
    private Integer voted;

    public static MemberDTO toMemberDTO (MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserid(memberEntity.getUserid());
        memberDTO.setUserpw(memberEntity.getUserpw());
        memberDTO.setUsername(memberEntity.getUsername());
        memberDTO.setUserlevel(memberEntity.getUserlevel());
        memberDTO.setVoted(memberEntity.getVoted());




        return memberDTO;
    }
}