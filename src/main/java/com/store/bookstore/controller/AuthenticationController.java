package com.store.bookstore.controller;


import com.store.bookstore.model.User;
import com.store.bookstore.service.IAuthenticationService;
import com.store.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IUserService userService;

    public AuthenticationController(IAuthenticationService authenticationService, IUserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<User> SignUp(@RequestBody User user){


userService.saveUser(user);

return new ResponseEntity<User>(HttpStatus.CREATED);


    }
}
