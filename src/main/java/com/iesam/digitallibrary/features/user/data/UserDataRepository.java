package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {

    private UserFileLocalDataSource userFileLocalDataSource;
    private UserMemLocalDataSource userMemLocalDataSource= UserMemLocalDataSource.newInstance();

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void save(User user) {
        userFileLocalDataSource.save(user);
    }

    @Override
    public void delete(String dni) {
        userFileLocalDataSource.delete(dni);
    }

    @Override
    public void modify(String dni, User user) {
        User usuario = userFileLocalDataSource.findById(dni);
        if(usuario != null){
            userFileLocalDataSource.delete(dni);
            userFileLocalDataSource.save(user);
        }
        else{
            System.out.println("No existe el usuario");
        }
    }

    @Override
    public ArrayList<User> obtains() {
        List<User> usersFile= userFileLocalDataSource.findAll();
        List<User> usersMem= userMemLocalDataSource.findAll();
        if(usersMem.size()==usersFile.size()){
            if(!usersMem.isEmpty()) {
                return new ArrayList<>(usersMem);
            }else{
                return null;
            }
        } else if(usersFile.size()>usersMem.size()) {
            for(User user:usersMem){
                userMemLocalDataSource.delete(user.getDni());
            }
           for(User u: usersFile){
               userMemLocalDataSource.save(u);
           }
            List<User> newUsersMem= userMemLocalDataSource.findAll();
           return (ArrayList<User>) newUsersMem;
        }
        return null;
    }

    @Override
    public User obtain(String dni) {
        User userMem=userMemLocalDataSource.findById(dni);
        if(userMem==null){
            userMem=userFileLocalDataSource.findById(dni);
            if(userMem==null){
                return null;
            }
            else{
                userMemLocalDataSource.save(userMem);
                return userMem;
            }
        }else{
            return userMem;
        }
    }
}
