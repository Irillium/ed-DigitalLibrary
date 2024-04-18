package com.iesam.digitallibrary.features.user.data;

import com.iesam.digitallibrary.features.user.data.local.UserLocalFileDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {
    UserLocalFileDataSource userLocalFileDataSource = new UserLocalFileDataSource();
    @Override
    public void save(User user) {
        userLocalFileDataSource.save(user);
    }
}
