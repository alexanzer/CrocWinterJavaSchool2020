package ru.croc.java.school.lec2;

import java.util.HashMap;
import java.util.Map;

public class SimpleUserCache {
    private Map<String, User> users = new HashMap<>();

    public void put(User user) {
        this.users.put(user.getLogin(), user);
    }

    public User get(String login) {
        return users.get(login);
    }
}
