package com.iesam.digitallibrary.features.user.domain;

import com.iesam.digitallibrary.features.user.data.StubUserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteUserUseCaseTest {


    private DeleteUserUseCase deleteUserUseCase;
    private StubUserDataRepository stubUserDataRepository;
    @BeforeEach
    void setUp() {
        stubUserDataRepository=new StubUserDataRepository(UserMemLocalDataSource.newInstance());
        deleteUserUseCase=new DeleteUserUseCase(stubUserDataRepository);
    }

    @AfterEach
    void tearDown() {
        deleteUserUseCase=null;
        stubUserDataRepository=null;
    }
    @Test
    public void alPasarleUnUserExistenteLoBorra(){
        //Given
        User userUse=new User("3","Juan","xxxx","ggg@jd.ggg","8459","45/45/4950");
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        saveUserUseCase.execute(userUse);
        //When
        deleteUserUseCase.execute("3");
        //Then
        User delUser=stubUserDataRepository.obtain("3");
        Assertions.assertNull(delUser,"Usuario borrado/nulo");
    }
    @Test
    public void alPasarleUnUserQueNoExisteNoBorraNada(){
        //Given
        User userUse=new User("3","Juan","xxxx","ggg@jd.ggg","8459","45/45/4950");
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        saveUserUseCase.execute(userUse);
        //When
        deleteUserUseCase.execute("39");
        //Then
        User delUser=stubUserDataRepository.obtain("3");
        Assertions.assertNotNull(delUser,"El usuario no fue borrado");
    }
}