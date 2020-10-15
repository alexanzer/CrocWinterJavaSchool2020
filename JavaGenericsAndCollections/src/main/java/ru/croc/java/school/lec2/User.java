package ru.croc.java.school.lec2;

public class User implements CacheId {
    private String login;
    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String getId() {
        return getLogin();
    }
}
