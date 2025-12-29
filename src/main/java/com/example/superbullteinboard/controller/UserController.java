package com.example.superbullteinboard.controller;

import com.example.superbullteinboard.modal.User;
import com.example.superbullteinboard.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") // 1. 여기서 이미 공통 주소를 선언
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // [수정] 괄호 안의 "/api/users"를 지움 -> 결과 URL: /api/users
    @PostMapping
    public User createUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    // [수정] 여기도 -> 결과 URL: /api/users
    @GetMapping
    public List<User> getUser(){
        return userRepository.findAll();
    }

    // [수정] 앞에 중복된 부분은 지우고 뒤에 변수({userId})만 남긴다.
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new Exception("user not found");
    }

    // [수정] 여기도 중복 제거 -> 결과 URL: /api/users/{id}
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,
                           @PathVariable Long id) throws Exception {

        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not found with id" + id);
        }
        User existingUser = otp.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        // 새로 추가했던 content 필드의 업데이트 기능
        existingUser.setContent(user.getContent());

        return userRepository.save(existingUser);
    }

    // [수정] 여기도 중복 제거
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not exist with id" + id);
        }
        userRepository.deleteById(otp.get().getId());
        return "user deleted";
    }
}