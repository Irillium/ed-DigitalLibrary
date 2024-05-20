package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.StubDigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyDigitalBookUseCaseTest {
    ModifyDigitalBookUseCase modifyDigitalBookUseCase;
    StubDigitalBookDataRepository stubDigitalBookDataRepository;
    @BeforeEach
    void setUp() {
        stubDigitalBookDataRepository=new StubDigitalBookDataRepository(DigitalBookMemLocalDataSource.newInstance());
        modifyDigitalBookUseCase=new ModifyDigitalBookUseCase(stubDigitalBookDataRepository);
    }

    @AfterEach
    void tearDown() {
        stubDigitalBookDataRepository=null;
        for(DigitalBook book: DigitalBookMemLocalDataSource.newInstance().findAll()){
            DigitalBookMemLocalDataSource.newInstance().delete(book.getIsbn());
        }
    }
    @Test
    public void cuandoSeLePideModificarUnLibroDigitalQueSiExiste(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        DigitalBook bookNew= new DigitalBook("d7yr","----","-----","----","----","----","----");
        stubDigitalBookDataRepository.save(bookTest);
        //When
        modifyDigitalBookUseCase.execute("d7yr",bookNew);
        //Then
        DigitalBook bookObs=stubDigitalBookDataRepository.obtain("d7yr");
        Assertions.assertEquals(bookObs.getName(),bookNew.getName());
        Assertions.assertEquals(bookObs.getAuthor(),bookNew.getAuthor());
        Assertions.assertEquals(bookObs.getPublisher(),bookNew.getPublisher());
        Assertions.assertEquals(bookObs.getGenre(),bookNew.getGenre());
        Assertions.assertEquals(bookObs.getSynopsis(),bookNew.getSynopsis());
        Assertions.assertEquals(bookObs.getPageCount(),bookNew.getPageCount());
    }
    @Test
    public void cuandoSeLePideModificarUnLibroDigitalQueNoExiste(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        DigitalBook bookNew= new DigitalBook("456","----","-----","----","----","----","----");
        stubDigitalBookDataRepository.save(bookTest);
        //When
        modifyDigitalBookUseCase.execute("456",bookNew);
        //Then
        DigitalBook bookObs=stubDigitalBookDataRepository.obtain("d7yr");
        Assertions.assertNotEquals(bookObs.getName(),bookNew.getName());
        Assertions.assertNotEquals(bookObs.getAuthor(),bookNew.getAuthor());
        Assertions.assertNotEquals(bookObs.getPublisher(),bookNew.getPublisher());
        Assertions.assertNotEquals(bookObs.getGenre(),bookNew.getGenre());
        Assertions.assertNotEquals(bookObs.getSynopsis(),bookNew.getSynopsis());
        Assertions.assertNotEquals(bookObs.getPageCount(),bookNew.getPageCount());
    }
}