package com.jay.user_service.dto;

import com.jay.user_service.entity.column.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UserDTO(Long id,
                      @NotBlank @Length(min = 3, max = 100) String username,
                      @NotBlank @Length(min = 8) String password,
                      @Email String emailId,
                      @NotNull Role role) {
}
