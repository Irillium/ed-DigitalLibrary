package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ReturnLoanUseCaseTest {
    ReturnLoanUseCase returnLoanUseCase;
    LoanDataRepository mockRepository=mock(LoanDataRepository.class);
    @BeforeEach
    void setUp() {
        returnLoanUseCase=new ReturnLoanUseCase(mockRepository);
    }

    @AfterEach
    void tearDown() {
        returnLoanUseCase=null;
    }
    @Test
    public void seCogeUnPrestamoExistenteYSeLeModifucaLaFechaDeDevolucionDeNuloAXFecha(){
        //Given
        User user1 = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");
        DigitalBook digitalBook1 = new DigitalBook("Libro","1234567890", "wuye","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");
        Loan loan1 = new Loan( user1, digitalBook1,null);
        //When
        LocalDate today =LocalDate.now();
        returnLoanUseCase.execute("1", today);
        //Then
        Mockito.verify(mockRepository, Mockito.times(1)).returned("1",today);
    }
}