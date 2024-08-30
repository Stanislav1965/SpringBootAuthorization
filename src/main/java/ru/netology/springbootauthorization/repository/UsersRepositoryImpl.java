package ru.netology.springbootauthorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootauthorization.domain.Authorities;
import ru.netology.springbootauthorization.model.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.netology.springbootauthorization.domain.Authorities.*;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private final List<Users> users;

    public UsersRepositoryImpl() {
        users = List.of(new Users("anton", "12345", new Authorities[]{WRITE, READ}),
                new Users("baton", "12345", new Authorities[]{DELETE}));
    }

    public List<Authorities> getUserAuthorities(String login, String password) {
        List<Authorities> authorities = new ArrayList<>();
        for (Users user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                authorities.addAll(Arrays.asList(user.getAuthorities()));
            }
        }
        return authorities;

    }

    public List<Users> getAll() {
        return this.users;
    }
}
