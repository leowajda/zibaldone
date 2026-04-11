package com.tutego.ch_06.advanced;

import jakarta.persistence.Embeddable;

// @Embeddable is always associated with a specific entity (like in the case of a composite key);
// the @Entity @Access policy cascades to @Embeddable types as well.
@Embeddable
public class LoginCredentials {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}