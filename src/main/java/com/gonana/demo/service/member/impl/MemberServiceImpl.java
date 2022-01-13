package com.gonana.demo.service.member.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gonana.demo.model.dto.MemberDTO;
import com.gonana.demo.model.entity.member.Member;
import com.gonana.demo.model.entity.member.MemberRepo;
import com.gonana.demo.service.member.MemberService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberRepo memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		Optional<Member> memberEntityWrapper = memberRepo.findByMemberId(memberId);
		Member memberEntity = memberEntityWrapper.orElse(null);

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
		
		return new User(memberEntity.getMemberId(), memberEntity.getMemberPw(), authorities);
	}

	@Override
	@Transactional
	public Integer save(MemberDTO memberDTO){
		Member member = null;
		LocalDateTime procDateTime = LocalDateTime.now();

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDTO.setMemberPw(passwordEncoder.encode(memberDTO.getMemberPw()));

		memberDTO.setModifyDate(procDateTime);
		memberDTO.setModifyId("SYSTEM");
		memberDTO.setCreateDate(procDateTime);
		memberDTO.setCreateId("SYSTEM");

		member = memberDTO.toEntity();

		return memberRepo.save(member).getId();
	}

}
