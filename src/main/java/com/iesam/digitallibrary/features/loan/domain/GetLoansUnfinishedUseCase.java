package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetLoansUnfinishedUseCase {
    private LoanRepository loanRepository;

    public GetLoansUnfinishedUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public ArrayList<Loan> execute(){
        return loanRepository.obtainUnfinisheds();
    }
}
