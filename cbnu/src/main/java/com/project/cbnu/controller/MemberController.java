package com.project.cbnu.controller;

import com.project.cbnu.dto.ListDTO;
import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.service.MemberService;
import com.project.cbnu.service.ListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;
    private final ListService listService;
    //회원가입 페이지 출력 요청
    @GetMapping ("/member/save")
    public String saveForm() {
        return "save";
    }

    //회원가입 페이지 정보 받아오기
    @PostMapping("/member/save")
    // RequestParam("")안에 들어가는 값은 동일한 name의 input 값을 받아옴
    public String save(@ModelAttribute MemberDTO memberDTO){
        // 회원가입시 기본 레벨 값인 "1"레벨 부여
        memberDTO.setUserlevel(1);
        // 회원가입시 누적투표값을 기본 값인 "0"으로 부여
        memberDTO.setVoted(0);

        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);

        // memberDTO 변경했기 때문에 save(memberDTO) 사용
        memberService.save(memberDTO);
        return "login";
    }

    @GetMapping ("/member/main")
    public String mainForm() {
        return "main";
    }

    @GetMapping ("/member/matchinfo")
    public String matchinfoForm(@ModelAttribute MemberDTO memberDTO,@ModelAttribute ListDTO listDTO, Model model, HttpSession session){


        session.setAttribute("match1participant", listService.ListLoad(1).getParticipant());
        session.setAttribute("match1listmin", listService.ListLoad(1).getListmin());
        session.setAttribute("match1listmax", listService.ListLoad(1).getListmax());
        session.setAttribute("match1Number", listService.ListLoad(1).getGamelist());
        session.setAttribute("match2participant", listService.ListLoad(2).getParticipant());
        session.setAttribute("match2listmin", listService.ListLoad(2).getListmin());
        session.setAttribute("match2listmax", listService.ListLoad(2).getListmax());
        session.setAttribute("match2Number", listService.ListLoad(2).getGamelist());
        session.setAttribute("match3participant", listService.ListLoad(3).getParticipant());
        session.setAttribute("match3listmin", listService.ListLoad(3).getListmin());
        session.setAttribute("match3listmax", listService.ListLoad(3).getListmax());
        session.setAttribute("match3Number", listService.ListLoad(3).getGamelist());
        session.setAttribute("match4participant", listService.ListLoad(4).getParticipant());
        session.setAttribute("match4listmin", listService.ListLoad(4).getListmin());
        session.setAttribute("match4listmax", listService.ListLoad(4).getListmax());
        session.setAttribute("match4Number", listService.ListLoad(4).getGamelist());
        model.addAttribute("match1",1);
        model.addAttribute("match2",2);
        model.addAttribute("match3",3);
        model.addAttribute("match4",4);
        model.addAttribute("matchcancle",100);
        return "matchinfo";
    }

//    @PostMapping ("/member/matchinfo")
//    public String MatchInfo(@RequestParam(value="matchnum") String Number){
//        System.out.println(Number);
//        System.out.println("1");
//        return "/match/match1";
//    }

    @GetMapping ("/member/usermanual")
    public String usermanualForm() {
        return "usermanual";
    }

    @GetMapping ("/member/ManagerMain")
    public String ManagerMainForm() {
        return "ManagerMain";
    }

    @GetMapping ("/member/MatchSetting")
    public String MatchSettingForm(@ModelAttribute MemberDTO memberDTO,@ModelAttribute ListDTO listDTO, Model model, HttpSession session){


        session.setAttribute("match1participant", listService.ListLoad(1).getParticipant());
        session.setAttribute("match1listmin", listService.ListLoad(1).getListmin());
        session.setAttribute("match1listmax", listService.ListLoad(1).getListmax());
        session.setAttribute("match1Number", listService.ListLoad(1).getGamelist());
        session.setAttribute("match2participant", listService.ListLoad(2).getParticipant());
        session.setAttribute("match2listmin", listService.ListLoad(2).getListmin());
        session.setAttribute("match2listmax", listService.ListLoad(2).getListmax());
        session.setAttribute("match2Number", listService.ListLoad(2).getGamelist());
        session.setAttribute("match3participant", listService.ListLoad(3).getParticipant());
        session.setAttribute("match3listmin", listService.ListLoad(3).getListmin());
        session.setAttribute("match3listmax", listService.ListLoad(3).getListmax());
        session.setAttribute("match3Number", listService.ListLoad(3).getGamelist());
        session.setAttribute("match4participant", listService.ListLoad(4).getParticipant());
        session.setAttribute("match4listmin", listService.ListLoad(4).getListmin());
        session.setAttribute("match4listmax", listService.ListLoad(4).getListmax());
        session.setAttribute("match4Number", listService.ListLoad(4).getGamelist());
        model.addAttribute("matchinfo1",1);
        model.addAttribute("matchinfo2",2);
        model.addAttribute("matchinfo3",3);
        model.addAttribute("matchinfo4",4);
        model.addAttribute("matchend",100);

        return "MatchSetting";
    }
    @GetMapping ("/member/UserSetting")
    public String UserSettingForm() {
        return "UserSetting";
    }

    @GetMapping ("/member/login")
    public String loginForm() {
        return "login";
    }

    // 회원정보 데이터베이스 바탕으로 로그인
    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);


        if (loginResult != null){
            //로그인 성공
            //로그인 성공한 유저의 userid 값을 loginUserid로 저장
            session.setAttribute("loginUserid", loginResult.getUserid());
            //로그인 성공한 유저의 username 값을 loginUserName로 저장
            //현재 구현 불가 Username 값이 Null로 나옴 -> 구현완료
            session.setAttribute("loginUsername", loginResult.getUsername());


            // 레벨업
            if(loginResult.getVoted() >= 20) {
                int level = loginResult.getUserlevel();
                level++;
                //  Userlevel 값 상승
                loginResult.setUserlevel(level);
                // Voted 초기화
                loginResult.setVoted(0);

            }
            // 레벨다운
            else if(loginResult.getVoted()<0){
                int level = loginResult.getUserlevel();
                loginResult.setUserlevel(--level);
                loginResult.setVoted(0);
            }

            // 로그인 성공한 유저의 level값을 loginUserLevel로 저장
            session.setAttribute("loginUserlevel", loginResult.getUserlevel());
            // 누적투표를 votedcount로 저장
            session.setAttribute("votedcount", loginResult.getVoted());
            // loginResult를 변경했기 때문에 save(loginResult) 사용
            memberService.save(loginResult);

            if(loginResult.getUserid().equals("manager")) {
                System.out.println("성공");
                return "ManagerMain";
            }


            return "firstmain";
        }
        else{
            model.addAttribute("message","로그인에 실패하였습니다.\n아이디 혹은 비밀번호를 확인해주세요.");
            model.addAttribute("searchUrl","/member/login");//로그인 실패
            return "loginfail";
        }
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



}