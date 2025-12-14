package com.example.superbullteinboard.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String accountId;
    private String name;
    private int type;
}
