package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CreateLoanUserCaseTest {
        CreateLoanUserCase createLoanUserCase;
        LoanDataRepository mockRepository=mock(LoanDataRepository.class);
    @BeforeEach
    void setUp() {
        createLoanUserCase=new CreateLoanUserCase(mockRepository);
    }

    @AfterEach
    void tearDown() {
        createLoanUserCase=null;
    }
    @Test
    public void reciboUnProductoDigitalYLoGuardoEnMemoria(){
        //Given
        User user = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");

        DigitalBook digitalBook = new DigitalBook("1234567890", "Tetleee","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");

        Loan loanSave = new Loan("1", user, digitalBook, "2024-04-24", "2024-05-24");

        //When
        createLoanUserCase.execute(loanSave);

        //Then
        Mockito.verify(mockRepository, Mockito.times(1)).save(loanSave);
    }
}