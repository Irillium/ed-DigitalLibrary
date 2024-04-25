package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

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
        userLocalFileDataSource.delete(dni);
        userLocalFileDataSource.save(user);
    }
}
