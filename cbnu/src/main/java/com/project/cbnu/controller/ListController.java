package com.project.cbnu.controller;

import com.project.cbnu.entity.MatchEntity;
import com.project.cbnu.repository.MatchRepository;
import com.project.cbnu.service.ListService;
import com.project.cbnu.service.MatchService;
import com.project.cbnu.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.cbnu.dto.ListDTO;
import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.dto.MemberDTO;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ListController {

    //생성자 주입
    private final MatchRepository matchRepository;
    private final ListService listService;
    private final MatchService matchService;

    // 결과 페이지 출력
    @GetMapping ("/list/matchresult")
    public String lineupForm(@ModelAttribute MemberDTO memberDTO, @ModelAttribute MatchDTO matchDTO, HttpSession session, Model model) {
        Object getPlayername = session.getAttribute("loginUserid");
        Optional<MatchEntity> FindedUserName = matchRepository.findByPlayer((String) getPlayername);
        if (FindedUserName.isEmpty()) {

            model.addAttribute("message", "매칭신청 내역이 존재하지 않습니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 매칭내역 없음
            return "loginfail";

        }
        MatchEntity matchEntity = FindedUserName.get();
        System.out.println();
        ListDTO lineupList = listService.ListLoad(matchEntity.getGamenum());
        session.setAttribute("matchingGameList", lineupList.getGamelist());
        session.setAttribute("matchingLevelMax", lineupList.getListmax());
        session.setAttribute("matchingLevelMin", lineupList.getListmin());
        session.setAttribute("matchingParticipant", lineupList.getParticipant());
        MatchDTO SubmitResult = matchService.MatchingSubmit((String) getPlayername, matchEntity.getGamenum());
        session.setAttribute("matchingUserTeam", SubmitResult.getTeam());
        System.out.println(SubmitResult.getTeam());




        return "matchresult";
    }

    @PostMapping("/list/matchresult")
    public String lineup(@ModelAttribute MatchService matchService, @ModelAttribute ListService listService, @ModelAttribute ListDTO listDTO, @ModelAttribute MatchDTO matchDTO, @ModelAttribute MemberDTO memberDTO, Object object) {



        return "main";
    }
}
