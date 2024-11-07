package com.sat.backend_fasep.common.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "New password must contain at least 8 characters and a maximum of 16 characters, " +
            "must contain at least one uppercase and one lowercase letter (Aa-Zz), " +
            "one special character (~, !, @, #, $, %, ^, &, ., ?) and " +
            "one number (0-9)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
