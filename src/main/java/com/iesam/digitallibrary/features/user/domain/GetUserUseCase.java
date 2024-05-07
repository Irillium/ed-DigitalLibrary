package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;

public class GetUserUseCase {
    UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User execute(String dni){
        return userRepository.obtain(dni);
    }
}
