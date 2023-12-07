package com.project.cbnu.controller;

import com.project.cbnu.service.MatchService;
import com.project.cbnu.service.ListService;
import com.project.cbnu.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.cbnu.dto.MatchDTO;
import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.dto.ListDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MatchController {

    //생성자 주입
    private final MatchService matchService;
    private final ListService listService;
    Integer MatchNumber;

    @GetMapping("/match/Match1Setting")
    public String Match1SettingForm() {
        return "Match1Setting";
    }
    @GetMapping("/match/MatchVoting")
    public String MatchVotingForm() {
        return "MatchVoting";
    }



    //회원가입 페이지 출력 요청
    @GetMapping("/match/match1")
    public String match1Form(@ModelAttribute MemberService memberService, @ModelAttribute MemberDTO memberDTO, @ModelAttribute ListDTO listDTO, Model model, HttpSession session) {

     //   MatchNumber = 1;

//        if (listService.ListLoad(MatchNumber).getParticipant() == 12) {
//
//            model.addAttribute("message", "매칭신청이 마감되었습니다.");
//            model.addAttribute("searchUrl", "/member/main");
//
//            // 매칭마감
//            return "loginfail";
//        }

        // session.setAttribute("participant", listService.ListLoad(MatchNumber).getParticipant());
        // session.setAttribute("listmin", listService.ListLoad(MatchNumber).getListmin());
        // session.setAttribute("listmax", listService.ListLoad(MatchNumber).getListmax());

        return "match1";

    }


    @PostMapping("/match/match1")
    public String match1(@ModelAttribute MatchDTO matchDTO, @ModelAttribute MemberDTO memberDTO, @ModelAttribute ListDTO listDTO, @ModelAttribute MemberService memberService, HttpSession session, Object object, Model model) {

        Object getPlayername = session.getAttribute("loginUserid");
        Object getPlayerlevel = session.getAttribute("loginUserlevel");
        // 객체선언 해서 플레이어 네임을 getPlayername에 변수를 지정하여 넣음
        MatchNumber = 1;

        MatchDTO SubmitResult = matchService.MatchingSubmit((String) getPlayername, MatchNumber);
        Integer MinLevel = listService.ListLoad(MatchNumber).getListmin();
        Integer MaxLevel = listService.ListLoad(MatchNumber).getListmax();
        Integer PlayerLevel = (Integer) getPlayerlevel;


        if (SubmitResult != null) {

            model.addAttribute("message", "매칭신청 내역이 이미 존재합니다.\n매칭내역을 확인해주세요");
            model.addAttribute("searchUrl", "/member/main");
            // 신청실패
            return "loginfail";

        } else if (PlayerLevel > MaxLevel || PlayerLevel < MinLevel) {
            System.out.println("적절하지 않음");
            model.addAttribute("message", "참여불가한 레벨입니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 참여불가한 레벨
            return "loginfail";
        }


        else if (listService.ListLoad(MatchNumber).getParticipant() == 11) {

            matchDTO.setGamenum(MatchNumber);
            matchDTO.setPlayer((String) getPlayername);
            // (String)으로 강제 치환해서 matchDTO에 넣기;
            matchDTO.setTeam("non");
            matchDTO.setPlayerlevel((Integer) getPlayerlevel);
            matchDTO.setPlayvoted(0);

            matchService.save(matchDTO);

            model.addAttribute("message", "매칭 신청이 완료되었습니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 신청성공

            ListDTO CountResult = listService.ListLoad(MatchNumber);
            int count = CountResult.getParticipant();
            count++;
            CountResult.setParticipant(count);
            listService.save(CountResult);
            divideTeams(MatchNumber);

            return "loginfail";
        } else if (listService.ListLoad(MatchNumber).getParticipant() == 12) {

            model.addAttribute("message", "매칭신청이 마감되었습니다.");
            model.addAttribute("searchUrl", "/member/main");

            // 매칭마감
            return "loginfail";
        } else {

            matchDTO.setGamenum(MatchNumber);
            matchDTO.setPlayer((String) getPlayername);
            // (String)으로 강제 치환해서 matchDTO에 넣기;
            matchDTO.setTeam("non");
            matchDTO.setPlayerlevel((Integer) getPlayerlevel);
            matchDTO.setPlayvoted(0);

            matchService.save(matchDTO);

            model.addAttribute("message", "매칭 신청이 완료되었습니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 신청성공

            ListDTO CountResult = listService.ListLoad(MatchNumber);
            int count = CountResult.getParticipant();
            count++;
            CountResult.setParticipant(count);
            listService.save(CountResult);


            return "loginfail";
        }
    }

    @GetMapping("/match/match2")
    public String match2Form(@ModelAttribute MemberService memberService, @ModelAttribute MemberDTO memberDTO, @ModelAttribute ListDTO listDTO, Model model, HttpSession session) {

        MatchNumber = 2;

//        if (listService.ListLoad(MatchNumber).getParticipant() == 12) {
//
//            model.addAttribute("message", "매칭신청이 마감되었습니다.");
//            model.addAttribute("searchUrl", "/member/main");
//
//            // 매칭마감
//            return "loginfail";
//        }

        session.setAttribute("participant", listService.ListLoad(MatchNumber).getParticipant());
        session.setAttribute("listmin", listService.ListLoad(MatchNumber).getListmin());
        session.setAttribute("listmax", listService.ListLoad(MatchNumber).getListmax());

        return "match1";

    }


    @PostMapping("/match/match2")
    public String match2(@ModelAttribute MatchDTO matchDTO, @ModelAttribute MemberDTO memberDTO, @ModelAttribute ListDTO listDTO, @ModelAttribute MemberService memberService, HttpSession session, Object object, Model model) {

        Object getPlayername = session.getAttribute("loginUserid");
        Object getPlayerlevel = session.getAttribute("loginUserlevel");
        // 객체선언 해서 플레이어 네임을 getPlayername에 변수를 지정하여 넣음
        MatchNumber = 2;

        MatchDTO SubmitResult = matchService.MatchingSubmit((String) getPlayername, MatchNumber);
        Integer MinLevel = listService.ListLoad(MatchNumber).getListmin();
        Integer MaxLevel = listService.ListLoad(MatchNumber).getListmax();
        Integer PlayerLevel = (Integer) getPlayerlevel;


        if (SubmitResult != null) {

            model.addAttribute("message", "매칭신청 내역이 이미 존재합니다.\n매칭내역을 확인해주세요");
            model.addAttribute("searchUrl", "/member/main");
            // 신청실패
            return "loginfail";

        } else if (PlayerLevel > MaxLevel || PlayerLevel < MinLevel) {
            System.out.println("적절하지 않음");
            model.addAttribute("message", "참여불가한 레벨입니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 참여불가한 레벨
            return "loginfail";
        }


        else if (listService.ListLoad(MatchNumber).getParticipant() == 11) {

            matchDTO.setGamenum(MatchNumber);
            matchDTO.setPlayer((String) getPlayername);
            // (String)으로 강제 치환해서 matchDTO에 넣기;
            matchDTO.setTeam("non");
            matchDTO.setPlayerlevel((Integer) getPlayerlevel);
            matchDTO.setPlayvoted(0);

            matchService.save(matchDTO);

            model.addAttribute("message", "매칭 신청이 완료되었습니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 신청성공

            ListDTO CountResult = listService.ListLoad(MatchNumber);
            int count = CountResult.getParticipant();
            count++;
            CountResult.setParticipant(count);
            listService.save(CountResult);
            divideTeams(MatchNumber);

            return "loginfail";
        } else if (listService.ListLoad(MatchNumber).getParticipant() == 12) {

            model.addAttribute("message", "매칭신청이 마감되었습니다.");
            model.addAttribute("searchUrl", "/member/main");

            // 매칭마감
            return "loginfail";
        } else {

            matchDTO.setGamenum(MatchNumber);
            matchDTO.setPlayer((String) getPlayername);
            // (String)으로 강제 치환해서 matchDTO에 넣기;
            matchDTO.setTeam("non");
            matchDTO.setPlayerlevel((Integer) getPlayerlevel);
            matchDTO.setPlayvoted(0);

            matchService.save(matchDTO);

            model.addAttribute("message", "매칭 신청이 완료되었습니다.");
            model.addAttribute("searchUrl", "/member/main");
            // 신청성공

            ListDTO CountResult = listService.ListLoad(MatchNumber);
            int count = CountResult.getParticipant();
            count++;
            CountResult.setParticipant(count);
            listService.save(CountResult);


            return "loginfail";
        }
    }




        private void divideTeams (Integer matchNumber){
            // A 팀과 B 팀의 초기화
            List<MatchDTO> players = matchService.getAllPlayersForMatch(matchNumber);
            List<MatchDTO> teamA = new ArrayList<>();
            List<MatchDTO> teamB = new ArrayList<>();

            // 플레이어를 레벨 순서로 정렬
            players.sort(Comparator.comparingInt(MatchDTO::getPlayerlevel));

            // 팀에 번갈아가며 추가
            for (int i = 0; i < players.size(); i++) {
                if (i % 2 == 0) {
                    teamA.add(players.get(i));
                } else {
                    teamB.add(players.get(i));
                }
            }

            // 팀 정보를 DB에 업데이트
            updateTeamsInDatabase(teamA, teamB);
        }

        //팀정보 db에 업데이트
        private void updateTeamsInDatabase (List < MatchDTO > teamA, List < MatchDTO > teamB){
            for (MatchDTO player : teamA) {
                player.setTeam("RED");
                matchService.save(player);
            }

            for (MatchDTO player : teamB) {
                player.setTeam("BLUE");
                matchService.save(player);
            }
        }
    }
