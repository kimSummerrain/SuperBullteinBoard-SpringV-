package com.example.superbullteinboard.domain.member;

import com.example.superbullteinboard.domain.member.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) throws IllegalAccessException {
        return memberService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws IllegalAccessException {
        return memberService.login(request);
    }
}