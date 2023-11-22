package com.project.cbnu.dto;

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
    private Integer id;
    private String userid;
    private String userpw;
    private String username;
    private String userlevel;
}
