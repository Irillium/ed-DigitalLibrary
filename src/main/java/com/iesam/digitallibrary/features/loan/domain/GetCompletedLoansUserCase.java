package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetCompletedLoansUserCase {
    LoanRepository loanRepository;

    public GetCompletedLoansUserCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public ArrayList<Loan> execute(){
        return loanRepository.obtainCompleteds();
    }
}
