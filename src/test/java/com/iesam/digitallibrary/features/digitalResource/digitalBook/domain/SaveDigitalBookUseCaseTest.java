package com.iesam.digitallibrary.features.digitalResource.digitalBook.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.DigitalBookDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class SaveDigitalBookUseCaseTest {
    SaveDigitalBookUseCase saveDigitalBookUseCase;
    DigitalBookDataRepository mockRepository= mock(DigitalBookDataRepository.class);
    @BeforeEach
    void setUp() {
        saveDigitalBookUseCase=new SaveDigitalBookUseCase(mockRepository);
    }

    @AfterEach
    void tearDown() {
        saveDigitalBookUseCase=null;
    }
    @Test
    public void seLePasaUnLibroYLoGuarda(){
        //Given
        DigitalBook bookTest= new DigitalBook("d7yr","titel","auzor","distribu","jere","isu","si");
        //When
        saveDigitalBookUseCase.execute(bookTest);
        //Then
        Mockito.verify(mockRepository, Mockito.times(1)).save(bookTest);
    }
}