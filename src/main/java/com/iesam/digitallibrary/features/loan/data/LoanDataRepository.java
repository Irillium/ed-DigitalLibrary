package com.iesam.digitallibrary.features.loan.data;

import com.iesam.digitallibrary.features.loan.data.local.LoanData;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.domain.LoanRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanDataRepository implements LoanRepository {

    private final LoanData loanBookData;
    public LoanDataRepository(LoanData loanBookData) {
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

    @Override
    public ArrayList<Loan> obtainUnfinisheds() {
        ArrayList<Loan> loans =(ArrayList<Loan>)loanBookData.findAll();
        ArrayList<Loan> loansUnfinished = new ArrayList<>();
        for(Loan l:loans){
            if(l.getReturnDate()==null){
                loansUnfinished.add(l);
            }
        }
        return loansUnfinished;
    }

    @Override
    public ArrayList<Loan> obtainCompleteds() {
        ArrayList<Loan> loans =(ArrayList<Loan>)loanBookData.findAll();
        ArrayList<Loan> loansUnfinished = new ArrayList<>();
        for(Loan l:loans){
            if(l.getReturnDate()!=null){
                loansUnfinished.add(l);
            }
        }
        return loansUnfinished;
    }

    @Override
    public void returned(String isbn, LocalDate endDate) {
        Loan loan=loanBookData.findById(isbn);
        if(loan==null){
            System.out.println("El prestamo no existe");
        }
        else{
            loan.setReturnDate(endDate);
            System.out.println("Prestamo devuelto");
        }

    }
}
