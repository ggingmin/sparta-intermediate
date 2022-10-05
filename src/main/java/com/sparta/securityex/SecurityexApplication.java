package com.sparta.securityex;

import com.sparta.securityex.domain.User;
import com.sparta.securityex.domain.UserRoleEnum;
import com.sparta.securityex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class SecurityexApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityexApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final List<User> users = Arrays.asList(
            new User("user1", passwordEncoder.encode("user1"), "user1@example.com", UserRoleEnum.USER),
            new User("admin", passwordEncoder.encode("admin"), "admin@example.com", UserRoleEnum.ADMIN)
        );

        List<User> savedUser = userRepository.saveAll(users);
        savedUser.forEach(System.out::println);
    }
}
