package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.user.domain.User;

public class Loan {
    public final String id;
    public final User user;
    public final DigitalBook digitalBook;
    public final String loanDate;
    public final String deadline;
    public final String returnDate;

    public Loan(String id, User user, DigitalBook digitalBook, String loanDate, String deadline, String returnDate) {
        this.id = id;
        this.user = user;
        this.digitalBook = digitalBook;
        this.loanDate = loanDate;
        this.deadline = deadline;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public DigitalBook getDigitalBook() {
        return digitalBook;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
