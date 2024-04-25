package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;

public class User {
    public final String dni;
    public final String name;
    public final String surnames;
    public final String email;
    public final String phone;
    public final String birthDate;

    public User(String dni, String name, String surnames, String email, String phone, String birthDate) {
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
