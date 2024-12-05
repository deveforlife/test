package com.sat.backend_fasep.common.annocustom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password password) {
    }

    @Override
    public boolean isValid(String newPassword, ConstraintValidatorContext cxt) {
        if (newPassword == null){
            return false;
        }
        else return newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&.?])(?=\\S+$).{8,16}");
    }
}
