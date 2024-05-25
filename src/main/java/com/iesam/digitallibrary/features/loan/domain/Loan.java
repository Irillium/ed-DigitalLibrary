package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.digitalResource.domain.DigitalResource;
import com.iesam.digitallibrary.features.user.domain.User;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    //Es una clase que genera ids dificilmente repetibles de java
    public final String id =  UUID.randomUUID().toString();;
    public final User user;
    public DigitalResource digitalResource;
    public final LocalDate loanDate;
    public final LocalDate deadline;
    private final LocalDate returnDate;
    private LocalDate today= LocalDate.now();

    public Loan( User user, DigitalResource digitalResource, LocalDate returnDate) {
        this.user = user;
        this.digitalResource = digitalResource;
        this.loanDate  = LocalDate.now();
        this.deadline = today.plusDays(60);
        this.returnDate=returnDate;
    }
    public Loan(User user, DigitalResource digitalResource, LocalDate loanDate, LocalDate deadline, LocalDate returnDate) {
        this.user = user;
        this.digitalResource = digitalResource;
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
