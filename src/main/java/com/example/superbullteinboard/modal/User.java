package com.example.superbullteinboard.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*; // 롬복 라이브러리 가져오기
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter             // 모든 필드의 Getter 자동 생성
@Setter             // 모든 필드의 Setter 자동 생성
@NoArgsConstructor  // 기본 생성자 (JPA 필수) 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
@Builder            // 빌더 패턴(.builder().build()) 사용 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String content;

    @NotBlank(message = "email을 입력하셔야됩니다.")
    @Email(message = "이메일이 형식에 맞아야 합니다. ex ) example@gmail.com")
    @Column(unique = true)
    private String email;

    private String phone;

    @NotBlank(message = "고객/직원 구분위해 필수 입력")
    private String role;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime updatedAt;

    @NotBlank
    private String password;

    // 👇 아래에 있던 50줄 넘는 생성자, Getter, Setter가 전부 사라졌습니다!
}