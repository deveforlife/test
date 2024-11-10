package com.sat.backend_fasep.common.annocustom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {
    @Override
    public void initialize(Username username) {
    }

    @Override
    public boolean isValid(String newUsername, ConstraintValidatorContext cxt) {
        if (newUsername == null){
            return false;
        }
        else return newUsername.matches("^\\S{3,25}$");
    }
}
