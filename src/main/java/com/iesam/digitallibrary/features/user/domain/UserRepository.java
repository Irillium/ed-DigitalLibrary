package com.iesam.digitallibrary.features.user.domain;

public interface UserRepository {
    void save(User user);
    void delete(String dni);
    void modify(String dni, User user);
}
