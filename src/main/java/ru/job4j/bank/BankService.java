package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Этот класс описывает главный сервис.
 */
public class BankService {
    /**
     * Хранение пользователей и списка их счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод добавляет пользователя в систему.
     * @param user пользователь, которого надо добавить в систему.
     */
    public void addUser(User user) {
        /**
         * При добавлении пользователя выполняется проверка, что такого пользователя нет в системе. Если есть, то новый
         * не добавляется.
         * По умолчанию к этому user нужно добавить пустой список - new ArrayList<Account>()
         */
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю
     * @param passport номер паспорта для идентификации пользователя
     * @param account счет пользователя
     */
    public void addAccount(String passport, Account account) {
        /**
         * Получаем пользователя по паспорту.
         */
        User user = findByPassport(passport);
        if (user != null) {
            /**
             * Получение списка счетов пользователя из Map<User, List<Account>> users
             */
            List<Account> accounts = users.get(user);
            /**
             * Если счета account нет в списке счетов пользователя - добавляется в список.
             */
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя user по паспорту
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя user, если найден, или null, если не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск счета пользователя по реквизитам
     * @param passport номер паспорта для поиска пользователя по номеру паспорту
     * @param requisite реквизиты счета для поиска
     * @return возвращает счет account
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Vетод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя от которого надо перевести деньги
     * @param srcRequisite реквизиты счета, с которого надо перевести деньги
     * @param destPassport паспорт пользователя которому надо перевести деньги
     * @param destRequisite реквизиты счета, на который надо перевести деньги
     * @param amount сумма перевода
     * @return возвращает true, если перевод успешен; и false, если не удалось выполнить перевод
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc == null || accountDest == null || accountSrc.getBalance() < amount) {
            return false;
        }
        accountDest.setBalance(accountDest.getBalance() + amount);
        accountSrc.setBalance(accountSrc.getBalance() - amount);
        return true;
    }
}