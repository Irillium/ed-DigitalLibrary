package com.iesam.digitallibrary.features.loan.domain;

public class DeleteLoanUseCase {
    LoanRepository loanRepository;

    public DeleteLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String id){
        loanRepository.delete(id);
    }
}
