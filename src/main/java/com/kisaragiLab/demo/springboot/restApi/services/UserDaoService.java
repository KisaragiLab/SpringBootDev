package com.kisaragiLab.demo.springboot.restApi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().plusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().plusYears(25)));
        users.add(new User(++userCount, "Jim", LocalDate.now().plusYears(20)));
    }
    
    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

}
