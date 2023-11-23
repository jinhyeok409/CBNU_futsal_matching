package com.project.cbnu.controller;

import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;
    //회원가입 페이지 출력 요청
    @GetMapping ("/member/save")
    public String saveForm() {
        return "save";
    }

    //회원가입 페이지 정보 받아오기
    @PostMapping("/member/save")
    // RequestParam("")안에 들어가는 값은 동일한 name의 input 값을 받아옴
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

    //회원정보 데이터베이스 바탕으로 로그인
    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null){
            //로그인 성공
            //로그인 성공한 유저의 id 값을 loginUserid로 저장
            session.setAttribute("loginUserid", loginResult.getUserid());
            //로그인 성공한 유저의 id 값을 loginUserName로 저장
            session.setAttribute("loginUsername", loginResult.getUsername());
            return "main";
        }
        else{
            //로그인 실패
            return "login";
        }
    }
}

