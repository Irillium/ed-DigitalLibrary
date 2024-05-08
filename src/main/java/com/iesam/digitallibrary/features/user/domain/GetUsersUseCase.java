package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;

public class GetUsersUseCase {
    private UserRepository userRepository;

    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public ArrayList<User> execute(){
        return userRepository.obtains();
    }
}
