package com.sat.backend_fasep.common;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratePasswordWithRegex {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&.?";
    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&.?])(?=\\S+$).{14}$";

    public String generatePassword() {
        Pattern pattern = Pattern.compile(regex);
        String password = RandomStringUtils.random( 14, characters );
        Matcher matcher = pattern.matcher( password );

        if (matcher.matches()) {
            return password;
        } else {
            return generatePassword();
        }
    }
}
