package com.app.bookmyshow.controllers;

import com.app.bookmyshow.dtos.ResponseStatus;
import com.app.bookmyshow.dtos.SignUpRequestDto;
import com.app.bookmyshow.dtos.SignUpResponseDto;
import com.app.bookmyshow.models.User;
import com.app.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
        SignUpResponseDto responseDto = new SignUpResponseDto();
        User user = null;

        try {
            user = userService.signUp(
                    requestDto.getEmail(),
                    requestDto.getPassword()
            );

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setUserId(user.getId());
        } catch (Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
