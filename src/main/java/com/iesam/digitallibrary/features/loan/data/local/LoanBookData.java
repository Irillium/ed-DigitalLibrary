package com.iesam.digitallibrary.features.loan.data.local;


import com.iesam.digitallibrary.features.loan.domain.Loan;

import java.util.List;

public interface LoanBookData {
    public void save(Loan model);
    public void saveList(List<Loan> models);
    public Loan findById(String id);
    public List<Loan> findAll();
    public void delete(String modelId);
}
