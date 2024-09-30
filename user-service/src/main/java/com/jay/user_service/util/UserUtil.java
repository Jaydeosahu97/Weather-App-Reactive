package com.jay.user_service.util;

import com.jay.user_service.dto.UserDTO;
import com.jay.user_service.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserUtil {
    private static PasswordEncoder passwordEncoder;
    private static final String PASSWORD_MASK = "********";

    static {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.id());
        user.setUsername(userDTO.username());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setRole(userDTO.role());
        user.setEmailId(userDTO.emailId());
        return user;
    }

    public static UserDTO toUserDto(User user) {
        return new UserDTO(user.getId(), user.getUsername(), PASSWORD_MASK, user.getEmailId(), user.getRole());
    }
}
