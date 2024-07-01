package com.ansdev.course_management_backend;

import com.ansdev.course_management_backend.models.enums.user.UserStatus;
import com.ansdev.course_management_backend.models.mappers.CourseEntityMapper;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.payload.auth.SignUpPayLoad;
import com.ansdev.course_management_backend.models.properties.security.SecurityProperties;
import com.ansdev.course_management_backend.repository.UserRepository;
import com.ansdev.course_management_backend.services.security.AccessTokenManager;
import com.ansdev.course_management_backend.services.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseManagementBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementBackendApplication.class, args);
	}



	// private final SecurityProperties securityProperties;

	private final AccessTokenManager accessTokenManager;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) throws Exception {




//		User user = User.builder()
//				.name("TEST")
//				.surname("test")
//				.password(passwordEncoder.encode("123123"))
//				.roleId(2L)
//				.phoneNumber("123123123")
//				.status(UserStatus.ACTIVE)
//				.email("anar@gmail.com")
//				.build();
//
//		userService.insert(user);
//
//		System.out.println(userService.getByEmail("anar@gmail.com"));
//
//
//
}

	private static String convertToPrivateKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PRIVATE KEY-----\n");
		result.append(key);
		result.append("\n-----END PRIVATE KEY-----");
		return result.toString();
	}

	private static String convertToPublicKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PUBLIC KEY-----\n");
		result.append(key);
		result.append("\n-----END PUBLIC KEY-----");
		return result.toString();
	}
}
