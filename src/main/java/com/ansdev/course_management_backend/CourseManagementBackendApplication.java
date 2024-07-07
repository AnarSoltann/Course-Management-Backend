package com.ansdev.course_management_backend;

import com.ansdev.course_management_backend.services.redis.RedisService;
import com.ansdev.course_management_backend.services.security.AccessTokenManager;
import com.ansdev.course_management_backend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

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


	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private RedisService redisService;


	@Override
	public void run(String... args) throws Exception {


//		redisService.set("salam", "test", 5);
//		String salam =redisService.get("salam");
//		System.out.println(salam);
//
//		System.out.println("RedissonClient: " + redissonClient);
//		RBucket<String> testKey = redissonClient.getBucket("key");
//		testKey.set("value", Duration.of(5, ChronoUnit.SECONDS));
//
//		RBucket<String> testKey1 = redissonClient.getBucket("key");
//		String value = testKey1.get();
//
//		System.out.println(value);
//		Thread.sleep(6000);
//
//		RBucket<String> testKey2 = redissonClient.getBucket("key");
//		String value2 = testKey2.get();
//
//		System.out.println(value2);
//

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
