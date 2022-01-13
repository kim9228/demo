package com.gonana.demo.model.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Integer>{
    Optional<Member> findByMemberId(String memberId);
}
