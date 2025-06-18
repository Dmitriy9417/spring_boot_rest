package ru.netology.rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.rest.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    // Имитация хранилища пользователей (логин, пароль, права)
    private final Map<String, String> users = Map.of(
            "admin", "adminpass",
            "user", "userpass"
    );

    private final Map<String, List<Authorities>> authorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}
