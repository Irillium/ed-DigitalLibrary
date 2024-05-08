package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.DigitalResource;
import com.iesam.digitallibrary.features.user.domain.User;

public class Loan {
    public final String id;
    public final User user;
    public final DigitalResource digitalResource;
    public final String loanDate;
    public final String deadline;
    private String returnDate;

    public Loan(String id, User user, DigitalResource digitalResource, String loanDate, String deadline) {
        this.id = id;
        this.user = user;
        this.digitalResource = digitalResource;
        this.loanDate = loanDate;
        this.deadline = deadline;
        this.returnDate = null;
    }
    public Loan(String id, User user, DigitalResource digitalResource, String loanDate, String deadline, String returnDate) {
        this.id = id;
        this.user = user;
        this.digitalResource = digitalResource;
        this.loanDate = loanDate;
        this.deadline = deadline;
        this.returnDate = returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public DigitalResource getDigitalResource() {
        return digitalResource;
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
