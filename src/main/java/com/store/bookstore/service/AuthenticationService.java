package com.store.bookstore.service;


import com.store.bookstore.model.User;
import com.store.bookstore.security.UserPrincipal;
import com.store.bookstore.security.jwt.IJwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final IJwtProvider jwtProvider;

    public AuthenticationService(AuthenticationManager authenticationManager, IJwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public User signIn(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signedUser = userPrincipal.getUser();
        signedUser.setToken(jwt);

        return signedUser;


    }
}
