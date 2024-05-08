package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserData;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;

public class StubUserDataRepository implements UserRepository {
    private UserData userData;

    public StubUserDataRepository(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void save(User user) {
        userData.save(user);
    }

    @Override
    public void delete(String dni) {
        userData.delete(dni);
    }

    @Override
    public void modify(String dni, User user) {
        User u=userData.findById(dni);
        userData.delete(u.getDni());
        userData.save(user);
    }

    @Override
    public ArrayList<User> obtains() {
        return (ArrayList<User>)userData.findAll();
    }

    @Override
    public User obtain(String dni) {
        return userData.findById(dni);
    }
}
