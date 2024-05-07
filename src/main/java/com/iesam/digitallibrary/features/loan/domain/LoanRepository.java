package com.iesam.digitallibrary.features.loan.domain;

public interface LoanRepository {
    void save(Loan loan);
    void delete(String id);
}
