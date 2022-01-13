package com.gonana.demo.controller.main;

import com.gonana.demo.model.dto.MemberDTO;
import com.gonana.demo.service.main.MainService;
import com.gonana.demo.service.member.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class MainController{

    private final MainService mainService;
    private final MemberService memberService;

    @GetMapping("/")
    public String getSysdate(Model model){
        model.addAttribute("hello", mainService.getSysdate());

        return "index";
    }

    @GetMapping("/login")
    public String loginView(){
        return "member/login";
    }

    @GetMapping("/signup")
    public String signupView(){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/denied")
    public String deniedView(){
        return "/denied";
    }
}
