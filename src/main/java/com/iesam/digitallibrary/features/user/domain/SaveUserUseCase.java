package com.iesam.digitallibrary.features.user.domain;

public class SaveUserUseCase {
    UserRepository userRepository;

    public SaveUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void execute(User user){
        userRepository.save(user);
    }
}
