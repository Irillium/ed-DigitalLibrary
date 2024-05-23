package com.iesam.digitallibrary.features.loan.data;

import com.iesam.digitallibrary.features.digitalResource.domain.DigitalResource;
import com.iesam.digitallibrary.features.loan.data.local.LoanData;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.domain.LoanRepository;
import com.iesam.digitallibrary.features.user.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanDataRepository implements LoanRepository {

    private final LoanData loanData;
    public LoanDataRepository(LoanData loanBookData) {
        this.loanData = loanBookData;
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
        ArrayList<Loan> loans =(ArrayList<Loan>)loanData.findAll();
        return loans;
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
}
