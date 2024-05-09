package com.iesam.digitallibrary.features.user.domain;

public class GetUserUseCase {
    private UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User execute(String dni){
        return userRepository.obtain(dni);
    }
}
