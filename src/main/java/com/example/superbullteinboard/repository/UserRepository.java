package com.example.superbullteinboard.repository;

import com.example.superbullteinboard.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
