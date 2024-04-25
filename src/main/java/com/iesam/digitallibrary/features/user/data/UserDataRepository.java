package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;

public class UserDataRepository implements UserRepository {
    UserFileLocalDataSource userLocalFileDataSource = new UserFileLocalDataSource();
    @Override
    public void save(User user) {
        userLocalFileDataSource.save(user);
    }

    @Override
    public void delete(String dni) {
        userLocalFileDataSource.delete(dni);
    }

    @Override
    public void modify(String dni, User user) {
        User usuario = userLocalFileDataSource.findById(dni);
        if(usuario != null){
            userLocalFileDataSource.delete(dni);
            userLocalFileDataSource.save(user);
        }
        else{
            System.out.println("No existe el usuario");
        }
    }

    @Override
    public ArrayList<User> obtains() {
        return (ArrayList<User>) userLocalFileDataSource.findAll();
    }
}
