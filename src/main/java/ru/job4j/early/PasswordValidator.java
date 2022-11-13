package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (indexOfLowerCase(password) == -1) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (indexOfUpperCase(password) == -1) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (indexOfDigit(password) == -1) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (indexOfSpecialSymbol(password) == -1) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (password.toLowerCase().indexOf("qwerty") != -1
                || password.toLowerCase().indexOf("admin") != -1
                || password.toLowerCase().indexOf("user") != -1
                || password.toLowerCase().indexOf("password") != -1
                || password.indexOf("12345") != -1) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    public static int indexOfLowerCase(String password) {
        int rsl = -1;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isLowerCase(key)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static int indexOfUpperCase(String password) {
        int rsl = -1;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isUpperCase(key)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static int indexOfDigit(String password) {
        int rsl = -1;
        char[] arrChars = password.toCharArray();
        for (int index = 0; index < arrChars.length; index++) {
            char key = arrChars[index];
            if (Character.isDigit(key)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static int indexOfSpecialSymbol(String password) {
        int rsl = -1;
        for (int index = 0; index < password.length(); index++) {
            int code  = password.codePointAt(index);
            if (code == 36 || code == 95) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String password = "TYU_w123qwerty";
        System.out.println(validate(password));
    }
}
