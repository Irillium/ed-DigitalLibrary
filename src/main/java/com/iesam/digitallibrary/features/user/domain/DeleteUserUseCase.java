package com.iesam.digitallibrary.features.user.domain;

public class DeleteUserUseCase {
    private UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String dni){
        userRepository.delete(dni);
    }
}
