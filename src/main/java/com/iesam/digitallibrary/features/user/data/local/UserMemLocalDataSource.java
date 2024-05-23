package com.iesam.digitallibrary.features.user.data.local;


import com.iesam.digitallibrary.features.user.domain.User;

import java.util.*;

public class UserMemLocalDataSource implements UserData {

    private static UserMemLocalDataSource userMemLocalDataSource=null;
    public static UserMemLocalDataSource newInstance(){
        if(userMemLocalDataSource ==null){
            userMemLocalDataSource= new UserMemLocalDataSource();
        }
        return userMemLocalDataSource;
    }

    private UserMemLocalDataSource() {

    }

    private Map<String, User> dataStore = new TreeMap<>();

    public void save(User model) {
        dataStore.put(model.getDni(), model);
    }

    public void saveList(List<User> models) {
        for (User demo : models) {
            save(demo);
        }
    }

    public User findById(String id) {
        return dataStore.get(id);
    }

    public List<User> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }
}