package com.iesam.digitallibrary.features.user.domain;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.SaveUserUseCase;
import com.iesam.digitallibrary.features.user.domain.User;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveUserUseCaseTest {
    private SaveUserUseCase saveUserUseCase;
    UserDataRepository mockRepository = mock(UserDataRepository.class);

    @BeforeEach  
    void setUp() {
        saveUserUseCase=new SaveUserUseCase(mockRepository);
    }
    @AfterEach
    void tearDown() {
        saveUserUseCase=null;
    }
    @Test
    public void reciboUnUsuarioYLoGuardoEnMemoria(){
        //Given
        User userTest= new User("838383838L","Gabriel","Polo","Pololo39@gmail.com","394894839","10/05/2004");

        //When
        saveUserUseCase.execute(userTest);

        //Then
        Mockito.verify(mockRepository, Mockito.times(1)).save(userTest);
    }
}