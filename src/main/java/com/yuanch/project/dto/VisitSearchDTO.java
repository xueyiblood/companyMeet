package com.yuanch.project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VisitSearchDTO {

    @NotNull
    private Long suspectId;



}
