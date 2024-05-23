package com.iesam.digitallibrary.features.loan.domain;

import java.time.LocalDate;

public class ReturnLoanUseCase {
    private LoanRepository loanRepository;

    public ReturnLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String isbn, LocalDate today){
            loanRepository.returned(isbn, today);
    }
}
