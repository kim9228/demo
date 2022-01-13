package com.gonana.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Getter
@Builder(builderClassName = "CommonBuilder")
@JsonDeserialize(builder = CommonDTO.CommonDTOBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonDTO {
    private String sysdate;

    @JsonPOJOBuilder(withPrefix="")
    public static class CommonDTOBuilder{}
}
