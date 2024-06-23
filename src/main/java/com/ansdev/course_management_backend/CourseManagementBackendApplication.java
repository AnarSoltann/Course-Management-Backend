package com.ansdev.course_management_backend;

import com.ansdev.course_management_backend.models.enums.user.UserStatus;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagementBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementBackendApplication.class, args);
	}


	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user= User.builder()
//				.name("John")
//				.surname("Doe")
//				.status(UserStatus.ACTIVE)
//				.roleId(1L)
//				.email("anar@gmail.com")
//				.phoneNumber("123456789")
//				.password("123456")
//				.build();
//		userRepository.insert(user);
//
//
	}
}
