package com.controlcandidaturas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationDTO {

    private Long id;
    private String name;
    private String email;
    private String affair;
    private String phone;
    private String cv;
    private String status;
    private String msg;
    private LocalDate date;
}