package com.jay.user_service.service.impl;

import com.jay.user_service.dto.UserDTO;
import com.jay.user_service.entity.User;
import com.jay.user_service.repository.UserRepository;
import com.jay.user_service.service.UserService;
import com.jay.user_service.util.UserUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDTO> registerUser(UserDTO userRequestData) {
        return userRepository.save(UserUtil.toUser(userRequestData)).log()
                .map(UserUtil::toUserDto).log();
    }

    @Override
    public Flux<UserDTO> listUser() {
        return userRepository.findAll().map(UserUtil::toUserDto);
    }
}
