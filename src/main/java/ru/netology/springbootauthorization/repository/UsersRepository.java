package ru.netology.springbootauthorization.repository;

import ru.netology.springbootauthorization.domain.Authorities;
import ru.netology.springbootauthorization.model.Users;
import java.util.List;


public interface UsersRepository {

    List<Authorities> getUserAuthorities(String user, String password);

    List<Users> getAll();
}
