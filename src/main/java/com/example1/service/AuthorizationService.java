package com.example1.service;

import com.example1.entity.Authorities;
import com.example1.exeptions.InvalidCredentials;
import com.example1.exeptions.UnauthorizedUser;
import com.example1.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) throw new InvalidCredentials("Username or password is empty");

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user,password);

        if (isEmpty(userAuthorities)) throw new UnauthorizedUser("Unknown user " + user);

        return userAuthorities;
    }

    boolean isEmpty (String str) {
        return str == null || str.isEmpty();
    }
    boolean isEmpty (List<?> str) {
        return str == null || str.isEmpty();
    }
}
