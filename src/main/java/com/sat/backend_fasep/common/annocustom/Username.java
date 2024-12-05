package com.sat.backend_fasep.common.annocustom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {
    String message() default "New username must contain at least 3 characters and a maximum of 25 characters, " +
            "no spaces allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
