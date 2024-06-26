package com.iesam.digitallibrary.features.loan.data.local;


import com.iesam.digitallibrary.features.loan.domain.Loan;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LoanMemLocalDataSource implements LoanData {

    private static LoanMemLocalDataSource digitalBookMemLocalDataSource=null;
    public static LoanMemLocalDataSource newInstance(){
        if(digitalBookMemLocalDataSource ==null){
            digitalBookMemLocalDataSource= new LoanMemLocalDataSource();
        }
        return digitalBookMemLocalDataSource;
    }
    private Map<String, Loan> dataStore = new TreeMap<>();

    public void save(Loan model) {
        dataStore.put(model.getId(), model);
    }

    public void saveList(List<Loan> models) {
        for (Loan demo : models) {
            save(demo);
        }
    }

    public Loan findById(String id) {
        return dataStore.get(id);
    }

    public List<Loan> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }
}