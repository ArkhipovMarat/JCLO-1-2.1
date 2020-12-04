package com.example1.repository;

import com.example1.entity.Authorities;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    // simple repository
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userValid(user,password)) return Arrays.asList(Authorities.READ,Authorities.WRITE);
        return null;
    }

    // simple validation
    public boolean userValid (String user, String password) {
        return "Ivan".equals(user) && "12345".equals(password);
    }
}
