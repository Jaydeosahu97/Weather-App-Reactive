package com.jay.user_service.repository;

import com.jay.user_service.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
