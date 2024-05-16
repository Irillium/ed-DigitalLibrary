package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserData;
import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {
    private UserData userData;

    public UserDataRepository(UserData userData) {
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
        User usuario = userData.findById(dni);
        if(usuario != null){
            userData.delete(dni);
            userData.save(user);
        }
        else{
            System.out.println("No existe el usuario");
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
