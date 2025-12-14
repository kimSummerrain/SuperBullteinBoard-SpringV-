package com.example.superbullteinboard.domain.member.dto;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String accountId;
    private String pwd;
    private String name;
    private String email;
}
