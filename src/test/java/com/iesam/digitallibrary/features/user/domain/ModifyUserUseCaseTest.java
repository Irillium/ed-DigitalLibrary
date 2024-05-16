package com.iesam.digitallibrary.features.user.domain;

import com.iesam.digitallibrary.features.user.data.StubUserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyUserUseCaseTest {
    private ModifyUserUseCase modifyUserUseCase;
    private StubUserDataRepository stubUserDataRepository;
    @BeforeEach
    void setUp() {
        stubUserDataRepository=new StubUserDataRepository(UserMemLocalDataSource.newInstance());
        modifyUserUseCase=new ModifyUserUseCase(stubUserDataRepository);
    }

    @AfterEach
    void tearDown() {
        modifyUserUseCase=null;
        stubUserDataRepository=null;
        for(User user:UserMemLocalDataSource.newInstance().findAll()){
            UserMemLocalDataSource.newInstance().delete(user.getDni());
        }
    }
    @Test
    public void elUsuarioExisteYEsModificado(){
        //Given
        User userExist=new User("69","Juan","xxxx","ggg@jd.ggg","8459","45/45/4950");
        User userNew=new User("69","Gabriel","Fernandez","Gogogo@jd.ggg","969696969","10/05/2094");
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        saveUserUseCase.execute(userExist);
        //When
        modifyUserUseCase.execute(userExist.dni,userNew);
        //Then
        User userMody=stubUserDataRepository.obtain("69");
        Assertions.assertEquals(userMody.getDni(),userNew.getDni());
        Assertions.assertEquals(userMody.getName(),userNew.getName());
        Assertions.assertEquals(userMody.getSurnames(),userNew.getSurnames());
        Assertions.assertEquals(userMody.getEmail(),userNew.getEmail());
        Assertions.assertEquals(userMody.getPhone(),userNew.getPhone());
        Assertions.assertEquals(userMody.getBirthDate(),userNew.getBirthDate());
    }
    @Test
    public void elUsuarioAlNoExistirNoSeHaceNada(){
        //Given
        User userExist=new User("123","Juan","xxxx","ggg@jd.ggg","8459","45/45/4950");
        User userNew=new User("69","Gabriel","Fernandez","Gogogo@jd.ggg","969696969","10/05/2094");
        SaveUserUseCase saveUserUseCase=new SaveUserUseCase(stubUserDataRepository);
        saveUserUseCase.execute(userExist);
        //When
        modifyUserUseCase.execute("69",userNew);
        //Then
        User userMody=stubUserDataRepository.obtain("123");
        Assertions.assertEquals(userExist,userMody);
    }
}