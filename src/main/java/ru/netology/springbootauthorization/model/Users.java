package ru.netology.springbootauthorization.model;

import ru.netology.springbootauthorization.domain.Authorities;

public class Users {
    private String login;
    private String password;
    private Authorities[] authorities;

    public Users() {
    }

    public Users(String login, String password, Authorities[] authorities) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Authorities[] authorities) {
        this.authorities = authorities;
    }

    public Authorities[] getAuthorities() {
        return authorities;
    }
}
