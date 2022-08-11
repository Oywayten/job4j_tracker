package ru.job4j.early;

import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Класс занимается проверкой пароля
 */
public class PasswordValidator {
    public static final String ALL_RIGHT = "Пароль валиден";
    public static final String LENGTH_ERROR = "Длина пароля должна находится в диапазоне [8, 32]";
    public static final String UP_ERROR = "Пароль должен содержать хотя бы один символ в верхнем регистре";
    public static final String LOW_ERROR = "Пароль должен содержать хотя бы один символ в нижнем регистре";
    public static final String DIGIT_ERROR = "Пароль должен содержать хотя бы одну цифру";
    public static final String CHAR_ERROR = "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)";
    public static final String QWERTY_ERROR
            = "Пароль не должен содержать подстрок без учета регистра: qwerty, 12345, password, admin, user";
    private static final String[] STOP_WORDS = {"qwerty", "12345", "12345", "admin", "user"};

    /**
     * Метод валидирует пароль с учетом всех ограничений
     * @param password строка пароля для валидации
     * @return результат валидации типа String
     */
    public static String validate(String password) {
        if (null == password) {
            throw new IllegalArgumentException("password is null");
        }
        int length = password.length();
        if (length < 8 || length > 32) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
        if (charsConditionsCheck(Character::isUpperCase, password)) {
            throw new IllegalArgumentException(UP_ERROR);
        }
        if (charsConditionsCheck(Character::isLowerCase, password)) {
            throw new IllegalArgumentException(LOW_ERROR);
        }
        if (charsConditionsCheck(Character::isDigit, password)) {
            throw new IllegalArgumentException(DIGIT_ERROR);
        }
        if (charsConditionsCheck(ch -> !Character.isDigit(ch)
                && !Character.isLetter(ch)
                && !Character.isWhitespace(ch), password)) {
            throw new IllegalArgumentException(CHAR_ERROR);
        }
        if (stopWordsCheck(String::contains, password)) {
            throw new IllegalArgumentException(QWERTY_ERROR);
        }
        return ALL_RIGHT;
    }

    /**
     * Метод проверяет пароль на наличие запрещенных вхождений
     * @param predicate предикат с условием для проверки
     * @param password строка пароля
     * @return true, если выполнено условие предиката
     */
    private static boolean stopWordsCheck(BiPredicate<String, String> predicate, String password) {
        boolean checkCondition = false;
        String lowPass = password.toLowerCase(Locale.ROOT);
        for (String s : STOP_WORDS) {
            if (predicate.test(lowPass, s)) {
                checkCondition = true;
                break;
            }
        }
        return checkCondition;
    }

    /**
     * Метод проверяет пароль посимвольно на соответствие предикату
     * @param predicate предикат с условием для проверки
     * @param password строка пароля
     * @return true, если символы не валидны условию предиката
     */
    private static boolean charsConditionsCheck(Predicate<Character> predicate, String password) {
        boolean checkCondition = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (predicate.test(c)) {
                checkCondition = true;
                break;
            }
        }
        return !checkCondition;
    }
}