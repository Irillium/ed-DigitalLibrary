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
    public ArrayList<Loan> obtain() {
        return null;
    }


    @Override
    public void returned(String isbn,LocalDate today) {
        Loan loan=loanData.findById(isbn);

        if(loan==null){
            System.out.println("El prestamo no existe");
        }
        else{
            Loan loan1= new Loan(loan.getUser(),loan.getDigitalResource(),loan.getLoanDate(),loan.getDeadline(),today);
            loanData.delete(isbn);
            loanData.save(loan1);
            System.out.println("Prestamo devuelto");
        }

    }
    public Loan obtain(String id){
        return loanData.findById(id);
    }
}
