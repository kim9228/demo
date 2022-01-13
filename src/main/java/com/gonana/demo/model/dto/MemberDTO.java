package com.gonana.demo.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.gonana.demo.model.entity.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderClassName = "MemberBuilder", toBuilder = true)
@JsonDeserialize(builder = MemberDTO.MemberDTOBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberDTO {

    private Integer id;
    private String memberId;
    private String memberPw;
    private String memberName;
    private LocalDateTime modifyDate;
    private String modifyId;
    private LocalDateTime createDate;
    private String createId;

    public Member toEntity(){
        return new Member(id, memberId, memberPw, memberName, modifyDate, modifyId, createDate, createId);
    }

    @JsonPOJOBuilder(withPrefix="")
    public static class MemberDTOBuilder{}
}
