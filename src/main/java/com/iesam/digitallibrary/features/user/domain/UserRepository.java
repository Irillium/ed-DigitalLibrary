package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;

public interface UserRepository {
    void save(User user);
    void delete(String dni);
    void modify(String dni, User user);
    ArrayList<User> obtains();
}
