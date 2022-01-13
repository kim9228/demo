package com.gonana.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderClassName = "MainBuilder")
@JsonDeserialize(builder = MainDTO.MainDTOBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainDTO {
    private String sysdate;

    @JsonPOJOBuilder(withPrefix="")
    public static class MainDTOBuilder{}
}
