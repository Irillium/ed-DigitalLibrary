package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.loan.data.StubLoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.local.LoanMemLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeleteLoanUseCaseTest {
    DeleteLoanUseCase deleteLoanUseCase;
    StubLoanDataRepository stubLoanDataRepository;
    @BeforeEach
    void setUp() {
        stubLoanDataRepository=new StubLoanDataRepository(LoanMemLocalDataSource.newInstance());
        deleteLoanUseCase=new DeleteLoanUseCase(stubLoanDataRepository);
        for(Loan loan: LoanMemLocalDataSource.newInstance().findAll()){
            LoanMemLocalDataSource.newInstance().delete(loan.getId());
        }
    }

    @AfterEach
    void tearDown() {
         deleteLoanUseCase=null;
         stubLoanDataRepository=null;
    }
    @Test
    public void seLePideEliminarUnPrestamoExistente(){
        //Given
        User user = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");
        DigitalBook digitalBook = new DigitalBook("1234567890", "Tetleee","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");
        Loan loanSave = new Loan("1", user, digitalBook, "2024-04-24", "2024-05-24");
        stubLoanDataRepository.save(loanSave);
        //When
        deleteLoanUseCase.execute("1");
        //Then
        Assertions.assertNull(stubLoanDataRepository.obtain("1"));
    }
    @Test
    public void seLePideEliminarUnPrestamoQueNoExiste(){
        //Given
        User user = new User("12345678A", "John", "Doe", "john@example.com", "123456789", "1990-01-01");
        DigitalBook digitalBook = new DigitalBook("1234567890", "Tetleee","Author 1", "Publisher 1", "Genre 1", "Synopsis 1", "100");
        Loan loanSave = new Loan("1", user, digitalBook, "2024-04-24", "2024-05-24");
        stubLoanDataRepository.save(loanSave);
        //When
        deleteLoanUseCase.execute("38");
        //Then
        Assertions.assertNotNull(stubLoanDataRepository.obtain("1"));
    }
}