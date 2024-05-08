package com.iesam.digitallibrary.features.loan.domain;

public class ReturnLoanUseCase {
    LoanRepository loanRepository;

    public ReturnLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String isbn,String endDate){
            loanRepository.returned(isbn,endDate);
    }
}
