package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetCompletedLoansUserCase {
    private LoanRepository loanRepository;

    public GetCompletedLoansUserCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public ArrayList<Loan> execute(){
        ArrayList<Loan> loans =loanRepository.obtain();
        ArrayList<Loan> loansCompleted = new ArrayList<>();
        for(Loan l:loans){
            if(l.getReturnDate()!=null){
                loansCompleted.add(l);
            }
        }
        return loansCompleted;
    }
}
