package com.jay.user_service.service;

import com.jay.user_service.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDTO> registerUser(UserDTO userRequestData);
    Flux<UserDTO> listUser();
}
