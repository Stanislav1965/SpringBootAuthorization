package ru.netology.springbootauthorization.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootauthorization.advice.InvalidCredentials;
import ru.netology.springbootauthorization.advice.UnauthorizedUser;
import ru.netology.springbootauthorization.domain.Authorities;
import ru.netology.springbootauthorization.model.Users;
import ru.netology.springbootauthorization.repository.UsersRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UsersRepository usersRepository;

    public AuthorizationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = usersRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public List<Users> getAll() {
        return usersRepository.getAll();
    }

}
