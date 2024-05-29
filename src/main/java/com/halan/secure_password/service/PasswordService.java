package com.halan.secure_password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {
    public List<String> validatePassword(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);
        validateUpperCase(password, failures);
        validateLowerCase(password, failures);
        validateNumber(password, failures);
        validateSpecialCharacter(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {
        if (password != null && password.length() < 8) {
            failures.add("Password length should be at least 8 characters");
        }
    }

    private void validateUpperCase(String password, List<String> failures) {
        if (!Pattern.matches(".*[A-Z].*", password)) {
            failures.add("Password must contain at least one upper case letter");
        }
    }

    private void validateLowerCase(String password, List<String> failures) {
        if (!Pattern.matches(".*[a-z].*", password)) {
            failures.add("Password must contain at least one lower case letter");
        }
    }

    private void validateNumber(String password, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", password)) {
            failures.add("Password must contain at least one number");
        }
    }

    private void validateSpecialCharacter(String password, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", password)) {
            failures.add("Password must contain at least one special character");
        }
    }
}
