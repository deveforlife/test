package com.sat.backend_fasep.common.enumpackage;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(EnumPattern enumPattern) {
        try{
            pattern = Pattern.compile(enumPattern.regexp());
        }catch (PatternSyntaxException pse){
            throw new IllegalArgumentException("Given regex is invalid", pse);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null){
            return false;
        }
        Matcher matcher = pattern.matcher(value.name());
        return matcher.matches();
    }
}
