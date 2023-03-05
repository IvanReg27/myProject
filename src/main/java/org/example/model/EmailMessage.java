package org.example.model;

import static org.example.StringValidationUtils.*;

public class EmailMessage {
    private final String email;
    private final String textMessage;

    public String getEmail() {
        return email;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public EmailMessage(String email, String textMessage) {
        if (!isValidEmail(email)) {
            throw new RuntimeException("email: " + email + " is invalid!");
        }
        if (!hasLengthMoreThan(textMessage, 3)) {
            throw new RuntimeException("message text: " + textMessage + " is invalid!");
        }
        if (!hasOnlyEmailAddressGmail(email)) {
            throw new RuntimeException("phone: " + email + " has invalid format email(Only: gmail.com)!");
        }
        this.email = email;
        this.textMessage = textMessage;
    }
}