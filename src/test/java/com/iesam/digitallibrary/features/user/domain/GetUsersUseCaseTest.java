package com.iesam.digitallibrary.features.user.domain;

import com.iesam.digitallibrary.features.user.data.StubUserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GetUsersUseCaseTest {
    private GetUsersUseCase getUsersUseCase;
    private StubUserDataRepository stubUserDataRepository;
    @BeforeEach
    void setUp() {
        stubUserDataRepository=new StubUserDataRepository(UserMemLocalDataSource.newInstance());
        getUsersUseCase=new GetUsersUseCase(stubUserDataRepository);
    }

    @AfterEach
    void tearDown() {
        getUsersUseCase=null;
        stubUserDataRepository=null;
        for(User user:UserMemLocalDataSource.newInstance().findAll()){
            UserMemLocalDataSource.newInstance().delete(user.getDni());
        }
    }
    @Test
    public void devuelveUnaListaConContenido(){
        //Given
        ArrayList<User> users= new ArrayList<>();
        users.add( new User("12345678A", "John", "Doe", "john.doe@example.com", "123456789", "1990-01-01"));
        users.add( new User("98765432B", "Alice", "Smith", "alice.smith@example.com", "987654321", "1985-05-15"));
        users.add( new User("24681357C", "Michael", "Johnson", "michael.johnson@example.com", "654987321", "1988-09-20"));
        users.add(new User("13579246D", "Emily", "Brown", "emily.brown@example.com", "456123789", "1993-03-10"));
        users.add( new User("98765431E", "Sophia", "Taylor", "sophia.taylor@example.com", "987654321", "1997-07-25"));
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        for(User user: users){
            saveUserUseCase.execute(user);
        }

        //When
        ArrayList<User> dataUsers= getUsersUseCase.execute();
        //Then

        Assertions.assertFalse(dataUsers.isEmpty());

    }
    @Test
    public void devuelveUnaListaVacia(){
        //Given

        //When
        ArrayList<User> dataUsers= getUsersUseCase.execute();
        //Then
        Assertions.assertTrue(dataUsers.isEmpty());
    }
}