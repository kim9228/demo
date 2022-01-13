package com.gonana.demo.service.member;

import com.gonana.demo.model.dto.MemberDTO;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService{
    Integer save(MemberDTO memberDTO);
}
