package com.iesam.digitallibrary.features.loan.data;

import com.iesam.digitallibrary.features.loan.data.local.LoanBookData;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.domain.LoanRepository;

import java.util.ArrayList;

public class LoanDataRepository implements LoanRepository {

    private LoanBookData loanBookData;
    public LoanDataRepository(LoanBookData loanBookData) {
        this.loanBookData = loanBookData;
    }


    @Override
    public void save(Loan loan) {
        loanBookData.save(loan);
    }

    @Override
    public void delete(String id) {
        loanBookData.delete(id);
    }
}
