package com.iesam.digitallibrary.features.loan.data;

import com.iesam.digitallibrary.features.loan.data.local.LoanData;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.domain.LoanRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class StubLoanDataRepository implements LoanRepository {
    LoanData loanData;

    public StubLoanDataRepository(LoanData loanData) {
        this.loanData = loanData;
    }

    @Override
    public void save(Loan loan) {
        loanData.save(loan);
    }

    @Override
    public void delete(String id) {
        loanData.delete(id);
    }

    @Override
    public ArrayList<Loan> obtainUnfinisheds() {
        ArrayList<Loan> loans =(ArrayList<Loan>)loanData.findAll();
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
        ArrayList<Loan> loans =new ArrayList<>();

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
        Loan loan=loanData.findById(isbn);
        if(loan==null){
            System.out.println("El prestamo no existe");
        }
        else{
            loan.setReturnDate(endDate);
            System.out.println("Prestamo devuelto");
        }

    }
    public Loan obtain(String id){
        return loanData.findById(id);
    }
}
