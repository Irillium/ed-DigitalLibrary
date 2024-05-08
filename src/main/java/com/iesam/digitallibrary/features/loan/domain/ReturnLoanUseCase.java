package com.iesam.digitallibrary.features.loan.domain;

public class ReturnLoanUseCase {
    private LoanRepository loanRepository;

    public ReturnLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String isbn,String endDate){
            loanRepository.returned(isbn,endDate);
    }
}
