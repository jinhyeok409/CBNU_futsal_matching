package com.project.cbnu.service;

import com.project.cbnu.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private  final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
    }
}
