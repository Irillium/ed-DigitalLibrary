package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.StubLoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.local.LoanMemLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetLoansUnfinishedUseCaseTest {
   @Mock
   LoanDataRepository loanDataRepository;
    GetLoansUnfinishedUseCase getLoansUnfinishedUseCase;
    @BeforeEach
    void setUp() {
        getLoansUnfinishedUseCase=new GetLoansUnfinishedUseCase(loanDataRepository);
    }

    @AfterEach
    void tearDown() {
        getLoansUnfinishedUseCase=null;
    }
    @Test
    public void devuelveUnaListaDePrestamosNoFinalizados(){
        //Given
        User user1 = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");
        User user2 = new User("87654321B", "Jane", "Smith", "jane@example.com", "987654321", "1995-05-05");

        DigitalBook digitalBook1 = new DigitalBook("1234567890", "wuye","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");
        DigitalBook digitalBook2 = new DigitalBook("0987654321", "wdspie","Author 2", "Publisher 2", "Genre 2", "Synopsis 2", "150");

        Loan loan1 = new Loan("1", user1, digitalBook1, "2024-04-24", "2024-05-24");
        Loan loan2 = new Loan("2", user2, digitalBook2, "2024-04-25", "2024-05-25");
        ArrayList<Loan> loansTest=new ArrayList<>();
        loansTest.add(loan1);
        loansTest.add(loan2);

        //When
        Mockito.when(loanDataRepository.obtainUnfinisheds()).thenReturn(loansTest);
        ArrayList<Loan> loansGet=getLoansUnfinishedUseCase.execute();
        //Then
        for (Loan l:loansGet){
            Assertions.assertNull(l.getReturnDate());
        }

    }

    @Test
    public void alPedirUnaListaDePrestamosFinalizadosDevuelveNulo(){
        //Given
        ArrayList<Loan> loansTest=new ArrayList<>();
        //When
        Mockito.when(loanDataRepository.obtainUnfinisheds()).thenReturn(loansTest=null);
        //Then
        Assertions.assertNull(getLoansUnfinishedUseCase.execute());
    }
}