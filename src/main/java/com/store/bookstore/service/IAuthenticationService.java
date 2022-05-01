package com.store.bookstore.service;

import com.store.bookstore.model.User;

public interface IAuthenticationService {
    User signIn(User signInRequest);
}
