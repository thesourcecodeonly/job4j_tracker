package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!indexOfLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!indexOfUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!indexOfDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!indexOfSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] arrInvalidStrings = {"qwerty", "admin", "user", "password", "12345"};
        for (int index = 0; index < arrInvalidStrings.length; index++) {
            if (password.toLowerCase().contains(arrInvalidStrings[index])) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }

    public static boolean indexOfLowerCase(String password) {
        boolean rsl = false;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isLowerCase(key)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean indexOfUpperCase(String password) {
        boolean rsl = false;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isUpperCase(key)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean indexOfDigit(String password) {
        boolean rsl = false;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isDigit(key)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean indexOfSpecialSymbol(String password) {
        boolean rsl = false;
        for (int index = 0; index < password.length(); index++) {
            int code  = password.codePointAt(index);
            if (code == 36 || code == 95) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String password = "TYU1_wqwerty";
        System.out.println(validate(password));
    }
}
