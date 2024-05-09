package com.iesam.digitallibrary.features.user.domain;

import com.iesam.digitallibrary.features.user.data.StubUserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetUserUseCaseTest {
    GetUserUseCase getUserUseCase;
    StubUserDataRepository stubUserDataRepository;
    @BeforeEach
    void setUp() {
        stubUserDataRepository=new StubUserDataRepository(UserMemLocalDataSource.newInstance());
        getUserUseCase=new GetUserUseCase(stubUserDataRepository);
    }

    @AfterEach
    void tearDown() {
         getUserUseCase=null;
        stubUserDataRepository=null;
    }
    @Test
    public void sePideUnUsuarioQueExisteYLoDevuelve(){
        //Given
        User user=new User("69","Gabriel","Fernandez","Gogogo@jd.ggg","969696969","10/05/2094");
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        saveUserUseCase.execute(user);

        //When
        User userGet=getUserUseCase.execute("69");
        //Then
        Assertions.assertEquals(userGet,user);
    }
    @Test
    public void sePideUnUsuarioQueNoExistePorLoQueDevuelveNullo(){
        //Given

        //When
        User userGet=getUserUseCase.execute("56");
        //Then
        Assertions.assertNull(userGet);
    }
}