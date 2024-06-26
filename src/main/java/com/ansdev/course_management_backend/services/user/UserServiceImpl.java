package com.ansdev.course_management_backend.services.user;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found")
//                () -> NotFound(User.class.getSimpleName(), "email", email)
        );
    }
}