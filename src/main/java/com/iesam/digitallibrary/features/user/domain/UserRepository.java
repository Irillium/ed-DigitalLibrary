package com.iesam.digitallibrary.features.user.domain;


import java.util.List;

public interface UserRepository {
    void save(User user);
    void delete(String dni);
    void modify(String dni, User user);
    List<User> obtains();
    User obtain(String dni);
}
