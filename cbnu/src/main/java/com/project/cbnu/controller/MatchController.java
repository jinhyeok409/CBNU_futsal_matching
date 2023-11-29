package com.project.cbnu.controller;

import com.project.cbnu.service.MatchService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.dto.MemberDTO;

@Controller
@RequiredArgsConstructor
public class MatchController {

    //생성자 주입
    private final MatchService matchService;






    //회원가입 페이지 출력 요청
    @GetMapping ("/match/match1")
    public String match1Form() {
        return "match1";
    }

    @PostMapping("/match/match1")
    public String match1(@ModelAttribute MatchDTO matchDTO, @ModelAttribute MemberDTO memberDTO,HttpSession session, Model model) {
        // 받은 데이터를 데이터베이스에 추가하는 로직을 수행합니다.
        // 이 예시에서는 간단하게 로그로 출력합니다.

        Object getPlayername = session.getAttribute("loginUserid");
        Object getPlayerlevel = session.getAttribute("loginUserlevel");
        // 객체선언 해서 플레이어 네임을 getPlayername에 변수를 지정하여 넣음

        matchDTO.setGamenum(1);
        matchDTO.setPlayer((String) getPlayername);
        // (String)으로 강제 치환해서 matchDTO에 넣기;
        matchDTO.setTeam("C");
        matchDTO.setPlayerlevel((Integer) getPlayerlevel);
        matchDTO.setPlayvoted(0);

        System.out.println((String) getPlayername);
        System.out.println((Integer) getPlayerlevel);


        matchService.save(matchDTO);

        // 클라이언트에 응답을 보냅니다. (예시로 "Success" 문자열을 보냅니다.)
        return "main";
    }
}
