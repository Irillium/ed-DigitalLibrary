package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.StubDigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetDigitalBooksUseCaseTest {
    GetDigitalBooksUseCase getDigitalBooksUseCase;
    StubDigitalBookDataRepository stubDigitalBookDataRepository;
    @BeforeEach
    void setUp() {
        stubDigitalBookDataRepository=new StubDigitalBookDataRepository(DigitalBookMemLocalDataSource.newInstance());
        getDigitalBooksUseCase=new GetDigitalBooksUseCase(stubDigitalBookDataRepository);
    }

    @AfterEach
    void tearDown() {
        stubDigitalBookDataRepository=null;
        getDigitalBooksUseCase=null;
        for(DigitalBook book: DigitalBookMemLocalDataSource.newInstance().findAll()){
            DigitalBookMemLocalDataSource.newInstance().delete(book.getIsbn());
        }
    }
    @Test
    public void devuelveUnaListaDeLibros(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        DigitalBook bookTest2= new DigitalBook("3844","----","-----","----","----","----","----");
        stubDigitalBookDataRepository.save(bookTest);
        stubDigitalBookDataRepository.save(bookTest2);
        //When

        //Then
        Assertions.assertNotNull(getDigitalBooksUseCase.execute());
    }
    @Test
    public void devuelveNulo(){
        //Given

        //When

        //Then
        Assertions.assertNull(getDigitalBooksUseCase.execute());
    }
}