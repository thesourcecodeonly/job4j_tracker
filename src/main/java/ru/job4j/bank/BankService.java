package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса по переводу денежных средств.
 * @author Vyacheslav Zhigalov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей производится в карте Map, где ключ - пользователь (объект User),
     * а значение - коллекция ArrayList со счетами этого пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     *
     * @param user - добавляемый пользователь (объект)
     */
    public void addUser(User user) {
        users.putIfAbsent(user,  new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы.
     * Метод ищет пользователя по паспорту и удаляет из системы.
     *
     * @param passport - паспорт пользователя (строка)
     * @return метод возвращает true - если пользователь удален успешно, в противном случае
     * возвращает false
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счет пользователя в систему. Метод ищет пользователя по паспорту, получаем список
     * счетов пользователя. У одного пользователя может быть несколько счетов. Если добавляемого счета
     * в списке нет, то добавляем.
     *
     * @param passport - паспорт пользователя (строка)
     * @param account - счет пользователя (объект Account)
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     *
     * @param passport - паспорт пользователя (строка)
     * @return - пользователя (объект User)
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по паспорту пользователя и номеру счета.
     *
     * @param passport - паспорт пользователя (строка)
     * @param requisite - счет пользователя (строка)
     * @return - счет пользователя (объект Account)
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод реализует перечисление денег с одного счета на другой
     *
     * @param srcPassport - паспорт пользователя, перечисляющего деньги
     * @param srcRequisite - счет пользователя, перечисляющего деньги
     * @param destPassport - паспорт пользователя, получающего деньги
     * @param destRequisite - счет пользователя, получающего деньги
     * @param amount - сумма перевода
     * @return - метод возвращает true - если перечисление денег выполнено успешно, в противном случае
     * возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }

        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
