package com.project.cbnu.controller;

import com.project.cbnu.service.ListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.cbnu.dto.ListDTO;
import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.dto.MemberDTO;

@Controller
@RequiredArgsConstructor
public class ListController {

    //생성자 주입
    private final ListService listService;

    // 결과 페이지 출력
    @GetMapping ("/list/match1result")
    public String lineupForm() {
        return "match1result";
    }

    @PostMapping("/list/match1result")
    public String lineup(@ModelAttribute ListDTO listDTO,@ModelAttribute MatchDTO matchDTO, @ModelAttribute MemberDTO memberDTO,HttpSession session, Object object) {




        Object getPlayername = session.getAttribute("loginUserid");
        Object getPlayerlevel = session.getAttribute("loginUserlevel");
        // 객체선언 해서 플레이어 네임을 getPlayername에 변수를 지정하여 넣음

        listDTO.setMin((Integer) 10);

        listService.save(listDTO);


        return "main";

    }
}