package com.shreyas.javacrud.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User Shreyas = new User(
                    "Shreyas Balachandran",
                    "shreyas@outlook.com",
                    "+919840361937",
                    LocalDate.of(1995, Month.JULY, 13),
                    "Chennai",
                    "Tamil Nadu",
                    "India");
            User JohnDoe = new User(
                    "John Doe",
                    "jdoe@outlook.com",
                    "+91987654321",
                    LocalDate.of(1999, Month.SEPTEMBER, 28),
                    "Are 51",
                    "Amusement Park",
                    "USA");

            userRepository.saveAll(List.of(Shreyas, JohnDoe));
        };
    }
}
