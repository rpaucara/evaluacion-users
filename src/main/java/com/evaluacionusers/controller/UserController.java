package com.evaluacionusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacionusers.busines.UserService;

@RestController
@RequestMapping("/users/v1")
public class UserController {
	@Autowired
    UserService usersService;
	
	@PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public Object user() {

        return usersService.postUser();
    }
}
