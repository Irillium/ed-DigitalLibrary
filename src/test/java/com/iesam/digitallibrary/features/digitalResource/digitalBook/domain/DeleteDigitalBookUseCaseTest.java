package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.StubDigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeleteDigitalBookUseCaseTest {
        DeleteDigitalBookUseCase deleteDigitalBookUseCase;
        StubDigitalBookDataRepository stubDigitalBookDataRepository;
    @BeforeEach
    void setUp() {
        stubDigitalBookDataRepository=new StubDigitalBookDataRepository(DigitalBookMemLocalDataSource.newInstance());
        deleteDigitalBookUseCase=new DeleteDigitalBookUseCase(stubDigitalBookDataRepository);
    }

    @AfterEach
    void tearDown() {
        stubDigitalBookDataRepository=null;
        deleteDigitalBookUseCase=null;
        for(DigitalBook book: DigitalBookMemLocalDataSource.newInstance().findAll()){
            DigitalBookMemLocalDataSource.newInstance().delete(book.getIsbn());
        }
    }
    @Test
    public void cuandoSeLePideEliminarUnLibroDigitalQueSiExiste(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        stubDigitalBookDataRepository.save(bookTest);
        //When
        deleteDigitalBookUseCase.execute("d7yr");
        //Then
        DigitalBook bookObs=stubDigitalBookDataRepository.obtain("d7yr");
        Assertions.assertNull(bookObs);
    }
    @Test
    public void cuandoSeLePideEliminarUnLibroDigitalQueNoExiste(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        stubDigitalBookDataRepository.save(bookTest);
        //When
        deleteDigitalBookUseCase.execute("RRRR");
        //Then
        DigitalBook bookObs=stubDigitalBookDataRepository.obtain("d7yr");
        Assertions.assertNotNull(bookObs);
    }
}