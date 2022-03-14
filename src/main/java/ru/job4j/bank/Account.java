package ru.job4j.bank;

import java.util.Objects;

/**
 * Этот класс описывает модель банковского счета.
 * Эта модель содержит поля: баланс и реквизиты.
 */
public class Account {
    /**
     * Реквизиты счета
     */
    private String requisite;
    /**
     * Баланс счета
     */
    private double balance;

    /**
     * Конструктор для создания счета
     * @param requisite передает реквизиты для создания нового счета
     * @param balance передает баланс для создания нового счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает реквизиты счета
     * @param requisite новые реквизиты в счет
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает баланс счета
     * @param balance новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals для сравнения аккаунтов по реквизитам
     * @param o объект для сравнения в методе
     * @return возвращает результат сравнение true или false при сравнении по реквизитам
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод для получения хэшкода
     * @return значение хэшкода типа типа инт
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}