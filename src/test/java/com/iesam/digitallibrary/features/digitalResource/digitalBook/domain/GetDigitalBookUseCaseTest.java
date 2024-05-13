package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.StubDigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetDigitalBookUseCaseTest {
    GetDigitalBookUseCase getDigitalBookUseCase;
    StubDigitalBookDataRepository stubDigitalBookDataRepository;
    @BeforeEach
    void setUp() {
        stubDigitalBookDataRepository=new StubDigitalBookDataRepository(DigitalBookMemLocalDataSource.newInstance());
        getDigitalBookUseCase=new GetDigitalBookUseCase(stubDigitalBookDataRepository);
    }

    @AfterEach
    void tearDown() {
        stubDigitalBookDataRepository=null;
        for(DigitalBook book: DigitalBookMemLocalDataSource.newInstance().findAll()){
            DigitalBookMemLocalDataSource.newInstance().delete(book.getIsbn());
        }
    }
    @Test
    public void seBuscaUnLibroQueExisteYLoDevuelve(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        stubDigitalBookDataRepository.save(bookTest);
        //When

        //Then
        Assertions.assertNotNull(getDigitalBookUseCase.execute("d7yr"));
    }
    @Test
    public void seBuscaUnLibroQueExisteYDevuelveNulo(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        stubDigitalBookDataRepository.save(bookTest);
        //When

        //Then
        Assertions.assertNull(getDigitalBookUseCase.execute("JJJJ"));
    }
}