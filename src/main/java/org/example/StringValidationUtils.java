package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_DIGITS =
            Pattern.compile("^[0-9]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_A_Z =
            Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE);

    //Homework lesson_4 (regex phone)

    private static final Pattern VALID_PHONE_RUS =
            Pattern.compile("/(\\+)([7]){1}-([0-9]){3}-([0-9]){3}-([0-9]){2}-([0-9]){2}/g", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_BY =
            Pattern.compile("/(\\+)([375]){3}-([0-9]){3}-([0-9]){3}-([0-9]){2}-([0-9]){2}/g", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_UA =
            Pattern.compile("/(\\+)([380]){3}-([0-9]){2}-([0-9]){3}-([0-9]){4}/g", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_KZ =
            Pattern.compile("/(\\+)([997]){3}-([0-9]){3}-([0-9]){3}-([0-9]){2}-([0-9]){2}/g", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean hasLengthMoreThan(String emailStr, int length) {
        return emailStr != null && emailStr.length() > length;
    }

    public static boolean hasOnlyDigits(String digit) {
        Matcher matcher = VALID_DIGITS.matcher(digit);
        return matcher.find();
    }

    public static boolean hasOnlyChars(String someString) {
        Matcher matcher = VALID_A_Z.matcher(someString);
        return matcher.find();
    }

    public static boolean hasOnlyPhoneRUS(String someString) {
        Matcher matcher = VALID_PHONE_RUS.matcher(someString);
        return matcher.find();
    }

    public static boolean hasOnlyPhoneBY(String someString) {
        Matcher matcher = VALID_PHONE_BY.matcher(someString);
        return matcher.find();
    }

    public static boolean hasOnlyPhoneUA(String someString) {
        Matcher matcher = VALID_PHONE_UA.matcher(someString);
        return matcher.find();
    }

    public static boolean hasOnlyPhoneKZ(String someString) {
        Matcher matcher = VALID_PHONE_KZ.matcher(someString);
        return matcher.find();
    }
}