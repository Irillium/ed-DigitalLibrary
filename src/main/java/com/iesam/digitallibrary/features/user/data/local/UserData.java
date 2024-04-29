package com.iesam.digitallibrary.features.user.data.local;

import com.iesam.digitallibrary.features.user.domain.User;

import java.util.List;

public interface UserData {
    public void save(User model);
    public void saveList(List<User> models);
    public User findById(String id);
    public List<User> findAll();
    public void delete(String modelId);
}
