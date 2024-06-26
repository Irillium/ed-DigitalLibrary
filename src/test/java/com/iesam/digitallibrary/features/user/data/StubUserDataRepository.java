package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserData;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

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
        if(u!=null){
            userData.delete(u.getDni());
            userData.save(user);
        }

    }

    @Override
    public ArrayList<User> obtains() {
        List<User> users= userData.findAll();
        if(!users.isEmpty()) {
            return new ArrayList<>(users);
        }
        else{
            return null;
        }
    }

    @Override
    public User obtain(String dni) {
        return userData.findById(dni);
    }
}
