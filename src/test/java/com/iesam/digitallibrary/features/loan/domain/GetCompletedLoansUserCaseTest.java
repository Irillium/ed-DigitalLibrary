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

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GetCompletedLoansUserCaseTest {
    GetCompletedLoansUserCase getCompletedLoansUserCase;

    LoanDataRepository mockRepository=mock(LoanDataRepository.class);
    @BeforeEach
    void setUp() {
        getCompletedLoansUserCase=new GetCompletedLoansUserCase(mockRepository);
    }

    @AfterEach
    void tearDown() {
        getCompletedLoansUserCase=null;
    }
    @Test
    public void devuelveUnaListaDePrestamosFinalizados(){
        //Given
        User user1 = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");
        User user2 = new User("87654321B", "Jane", "Smith", "jane@example.com", "987654321", "1995-05-05");

        DigitalBook digitalBook1 = new DigitalBook("1234567890", "wuye","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");
        DigitalBook digitalBook2 = new DigitalBook("0987654321", "wdspie","Author 2", "Publisher 2", "Genre 2", "Synopsis 2", "150");

        Loan loan1 = new Loan("1", user1, digitalBook1);
        Loan loan2 = new Loan("2", user2, digitalBook2);
        ArrayList<Loan> loansTest=new ArrayList<>();
        loansTest.add(loan1);
        loansTest.add(loan2);

        //When
        Mockito.when(mockRepository.obtainCompleteds()).thenReturn(loansTest);
        ArrayList<Loan> loansGet=getCompletedLoansUserCase.execute();
        //Then
        Assertions.assertNotNull(loansGet);

    }
    @Test
    public void devuelveUnaListaVacia(){
        //Given
        ArrayList<Loan> loansTest=new ArrayList<>();

        //When
        Mockito.when(mockRepository.obtainCompleteds()).thenReturn(loansTest);
        ArrayList<Loan> loansGet=getCompletedLoansUserCase.execute();
        //Then
        Assertions.assertTrue(loansGet.isEmpty());

    }
}