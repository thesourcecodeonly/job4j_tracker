package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user,  new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user, users.get(user));
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (List<Account> accounts : users.values()) {
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (List<Account> accounts : users.values()) {
                for (Account account : accounts) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

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

    public static void main(String[] args) {
        User user1 = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user1);
        System.out.println(bank.users);
        System.out.println("======================================");
        User user2 = new User("3433", "Petya Arsentsev");
        bank.addUser(user2);
        System.out.println(bank.users);
        System.out.println("======================================");
        System.out.println(bank.findByPassport("3433"));
    }
}
