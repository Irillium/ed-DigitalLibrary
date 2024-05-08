package com.iesam.digitallibrary.features.user.domain;

public class ModifyUserUseCase {
    private UserRepository userRepository;

    public ModifyUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void execute(String dni,User user){
        userRepository.modify(dni,user);
    }
}
