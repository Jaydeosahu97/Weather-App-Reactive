package com.jay.user_service.controller;

import com.jay.user_service.dto.UserDTO;
import com.jay.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Mono<ResponseEntity<UserDTO>> registerUser(@RequestBody @Valid UserDTO userRequestData) {
        return userService.registerUser(userRequestData).log().map(ResponseEntity::ok);
    }

    @GetMapping("/hello")
    public Mono<String> hello(@RequestParam String name) {
//        return ServerResponse.ok().bodyValue(String.format("Hello %s",name));
        return Mono.just(String.format("Hello %s", name)).log();
    }
}
