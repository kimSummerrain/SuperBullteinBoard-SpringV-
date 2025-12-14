package com.example.superbullteinboard.domain.member;

import com.example.superbullteinboard.domain.member.dto.LoginRequest;
import com.example.superbullteinboard.domain.member.dto.LoginResponse;
import com.example.superbullteinboard.domain.member.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String signup(SignupRequest request) throws IllegalAccessException {

        if(memberRepository.existsByAccountId(request.getAccountId())) {
            throw new IllegalAccessException("사용 중인 계정입니다.");
        }
        Member member = Member.builder()
                .accountId(request.getAccountId())
                .pwd(request.getPwd())
                .name(request.getName())
                .type(1)
                .build();

        memberRepository.save(member);
        return "회원가입 성공";
    }

    public LoginResponse login(LoginRequest request) throws IllegalAccessException {
        Member member=memberRepository.findByAccountId(request.getAccountId())
                .orElseThrow(()-> new IllegalAccessException("계정을 찾을 수 없습니다."));
        if(!member.getPwd().equals(request.getPassword())) {
            throw new IllegalAccessException("비밀번호가 틀렸습니다.");
        }

        return new LoginResponse(
                member.getAccountId(),
                member.getName(),
                member.getType()
        );
    }
}
