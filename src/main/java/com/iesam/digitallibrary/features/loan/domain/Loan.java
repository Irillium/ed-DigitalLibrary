package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.domain.DigitalResource;
import com.iesam.digitallibrary.features.user.domain.User;

import java.time.LocalDate;

public class Loan {
    public final String id;
    public final User user;
    public final DigitalResource digitalResource;
    public final LocalDate loanDate;
    public final LocalDate deadline;
    private LocalDate returnDate;
    private LocalDate today= LocalDate.now();

    public Loan(String id, User user, DigitalResource digitalResource) {
        this.id = id;
        this.user = user;
        this.digitalResource = digitalResource;
        this.loanDate  = LocalDate.now();
        this.deadline = today.plusDays(60);
    }

    public void setReturnDate(LocalDate returnDate) {
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

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
