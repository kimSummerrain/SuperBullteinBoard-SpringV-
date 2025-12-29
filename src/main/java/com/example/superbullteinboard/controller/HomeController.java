package com.example.superbullteinboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {       //서버의 포트로 요청이 잘 도착하는지 테스트

    @GetMapping
    public String HomeControllerHandler(){

        return "user service for booking system";}
}
