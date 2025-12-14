package com.example.superbullteinboard.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="members")
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @Column(name="account_id",nullable=false,length=50)
    private String accountId;//pk

    @Column(nullable = false)
    private String pwd;
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int type;//관리자=0, 일반 유저=1

    private void updatePwd(String newPwd) {
        this.pwd = newPwd;
    }
}
