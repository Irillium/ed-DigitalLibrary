package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetLoansUnfinishedUseCase {
    private LoanRepository loanRepository;

    public GetLoansUnfinishedUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public ArrayList<Loan> execute(){
        ArrayList<Loan> loans=loanRepository.obtain();
        ArrayList<Loan> loansUnfinished = new ArrayList<>();
        for(Loan l:loans){
            if(l.getReturnDate()==null){
                loansUnfinished.add(l);
            }
        }
        return loansUnfinished;
    }
}
