package com.sebCzabak.fullstackProject.registration;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class RegistrationRequest {
    private final String firstName;
    private final String userName;
    private final String email;
    private final String password;

    public RegistrationRequest(String firstName, String userName, String email, String password) {
        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(userName, that.userName) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, userName, email, password);
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
