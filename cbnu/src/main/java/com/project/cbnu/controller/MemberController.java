package com.project.cbnu.controller;

import com.project.cbnu.dto.MemberDTO;
import com.project.cbnu.service.MemberService;
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
        return "index";
    }

}

