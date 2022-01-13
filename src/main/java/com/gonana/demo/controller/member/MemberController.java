package com.gonana.demo.controller.member;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@PreAuthorize("hasRole('ROLE_MEMBER')")
@RequestMapping("/member")
public class MemberController {
    
    @GetMapping("/info")
    public String userInfoView(){
        return "member/info";
    }
}
