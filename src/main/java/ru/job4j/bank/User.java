package ru.job4j.bank;

import java.util.Objects;

/**
 * Этот класс описывает модель пользователя банка.
 * Эта модель содержит поля: номер паспорта и ФИО.
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Конструктор экземпляра User. Принимает параметры
     * @param passport номер паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод получает номер паспорта
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает номер паспорта
     * @param passport номер паспорта, который присваивается пользователю
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод получает имя пользователя
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает имя пользователя
     * @param username имя пользователя для присвоения пользователю
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет метод equals и сравнивает пользователя по номеру паспорта
     * @param o объект для сравнения в методе
     * @return возвращает true или false результат сравнения пользователя по номеру паспорта
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}