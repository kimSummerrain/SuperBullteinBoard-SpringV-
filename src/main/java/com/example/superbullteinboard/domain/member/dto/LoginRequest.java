package com.example.superbullteinboard.domain.member.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String accountId;
    private String password;
}
