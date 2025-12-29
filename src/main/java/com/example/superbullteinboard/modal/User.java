package com.example.superbullteinboard.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity             //일단, 기본으로 유저 클래스에 대해서 정의해주고, 각 객체를 캡슐화. 유효성 검사를 거치고, 형식에 맞는 데이터만.
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



    public User() {

    }
    public User(String fullName,
                String email,
                String phone,
                String role,
                String password,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }     //set메서드를 통해 받는것처럼 보이는 이유는 스프링부트의 API 덕분.
          // UserController의 @RequestBody 덕분 본문에 있는 JSON데이터를 USER로 자동 변환.


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
