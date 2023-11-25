package com.project.cbnu.entity;

import com.project.cbnu.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user")
public class MemberEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Id
    private String userid;

    @Column
    private String userpw;

    @Column
    private String username;

    @Column
    private Integer userlevel;

    @Column
    private Integer voted;


    // DTO -> Entity
    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserid(memberDTO.getUserid());
        memberEntity.setUserpw(memberDTO.getUserpw());
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setUserlevel(memberDTO.getUserlevel());
        memberEntity.setVoted(memberDTO.getVoted());





        return memberEntity;
    }
}
