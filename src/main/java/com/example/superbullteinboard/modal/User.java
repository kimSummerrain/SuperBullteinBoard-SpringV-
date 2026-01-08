package com.example.superbullteinboard.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


}