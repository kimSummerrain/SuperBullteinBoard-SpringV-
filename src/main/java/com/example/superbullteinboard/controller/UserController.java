package com.example.superbullteinboard.controller;

import com.example.superbullteinboard.modal.User;
import com.example.superbullteinboard.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor; // 롬복 추가
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor // 👈 final이 붙은 필드를 위한 생성자를 자동으로 만들어줍니다.
public class UserController {

    // [변경 포인트] @Autowired를 지우고 final을 붙입니다.
    private final UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long id) throws Exception {
        // ... (내용 동일)
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new Exception("user not found");
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        // ... (내용 동일)
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not found with id" + id);
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setContent(user.getContent());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws Exception {
        // ... (내용 동일)
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not exist with id" + id);
        }
        userRepository.deleteById(otp.get().getId());
        return "user deleted";
    }
}