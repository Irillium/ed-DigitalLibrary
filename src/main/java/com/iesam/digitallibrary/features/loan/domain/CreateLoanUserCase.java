package com.iesam.digitallibrary.features.loan.domain;

public class CreateLoanUserCase {
    private LoanRepository loanRepository;

    public CreateLoanUserCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(Loan loan){
        loanRepository.save(loan);
    }
}
