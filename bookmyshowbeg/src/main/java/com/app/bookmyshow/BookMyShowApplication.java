package com.app.bookmyshow;

import com.app.bookmyshow.dtos.SignUpRequestDto;
import com.app.bookmyshow.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setEmail("swethakonduri@gmail.com");
        signUpRequestDto.setPassword("abc123");

        userController.signUp(signUpRequestDto);
    }
}
