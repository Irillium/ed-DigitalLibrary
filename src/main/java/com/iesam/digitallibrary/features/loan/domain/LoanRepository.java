package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public interface LoanRepository {
    void save(Loan loan);
    void delete(String id);
    ArrayList<Loan> obtainUnfinisheds();
}