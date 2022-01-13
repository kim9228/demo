package com.gonana.demo.model.entity.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "TMEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MEMBER_ID", length = 255, nullable = false, unique = true)
    private String memberId;

    @Column(name = "MEMBER_PW", length = 255, nullable = false)
    private String memberPw;

    @Column(name = "MEMBER_NAME", length = 255, nullable = false)
    private String memberName;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Column(name = "MODIFY_ID")
    private String modifyId;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "CREATE_ID")
    private String createId;
    
    public Member(){}

    @Builder
    public Member(Integer id, String memberId, String memberPw, String memberName
                , LocalDateTime modifyDate, String modifyId, LocalDateTime createDate, String createId){
        this.id = id;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.modifyDate = modifyDate;
        this.modifyId = modifyId;
        this.createDate = createDate;
        this.createId = createId;
    }
}
