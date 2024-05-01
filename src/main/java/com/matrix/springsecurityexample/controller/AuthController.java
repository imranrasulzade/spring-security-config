package com.matrix.springsecurityexample.controller;


import com.matrix.springsecurityexample.dto.ClientReq;
import com.matrix.springsecurityexample.dto.LoginReq;
import com.matrix.springsecurityexample.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @ResponseBody
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody @Valid LoginReq loginReq)  {
        return authService.authenticate(loginReq);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid ClientReq clientReq)  {
        authService.register(clientReq);
    }
}
