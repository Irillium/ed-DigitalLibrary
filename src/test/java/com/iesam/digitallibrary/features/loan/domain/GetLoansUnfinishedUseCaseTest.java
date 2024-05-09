package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.loan.data.StubLoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.local.LoanMemLocalDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GetLoansUnfinishedUseCaseTest {
    StubLoanDataRepository stubLoanDataRepository;
    GetLoansUnfinishedUseCase getLoansUnfinishedUseCase;
    @BeforeEach
    void setUp() {
        stubLoanDataRepository=new StubLoanDataRepository(LoanMemLocalDataSource.newInstance());
        getLoansUnfinishedUseCase=new GetLoansUnfinishedUseCase(stubLoanDataRepository);
    }

    @AfterEach
    void tearDown() {
        stubLoanDataRepository=null;
        getLoansUnfinishedUseCase=null;
        for(Loan loan: LoanMemLocalDataSource.newInstance().findAll()){
            LoanMemLocalDataSource.newInstance().delete(loan.getId());
        }
    }
}