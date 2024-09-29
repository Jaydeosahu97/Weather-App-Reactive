package com.jay.user_service.service.impl;

import com.jay.user_service.dto.UserDTO;
import com.jay.user_service.repository.UserRepository;
import com.jay.user_service.service.UserService;
import com.jay.user_service.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDTO> registerUser(UserDTO userRequestData) {
        return userRepository.save(UserUtil.toUser(userRequestData)).log().map(UserUtil::toUserDto).log();
    }

    @Override
    public Flux<UserDTO> listUser() {
        return null;
    }
}
