package tasks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank {
    private final Map<Long, BankAccount> accounts = new ConcurrentHashMap<>();
    private long nextAccountId = 1;
    private final Lock lock = new ReentrantLock();

    public BankAccount createAccount(int initialBalance) {
        BankAccount newAccount = new BankAccount(nextAccountId++);
        newAccount.deposit(initialBalance);
        accounts.put(newAccount.getAccountId(), newAccount);
        return newAccount;
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        Lock firstLock, secondLock;
        if (fromAccount.getAccountId() < toAccount.getAccountId()) {
            firstLock = fromAccount.getLock();
            secondLock = toAccount.getLock();
        } else {
            firstLock = toAccount.getLock();
            secondLock = fromAccount.getLock();
        }

        firstLock.lock();
        secondLock.lock();
        try {
            performTransfer(fromAccount, toAccount, amount);
        } finally {
            secondLock.unlock();
            firstLock.unlock();
        }
    }

    private void performTransfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from account " + fromAccount.getAccountId() +
                    " to account " + toAccount.getAccountId());
        } else {
            System.out.println("Insufficient funds for transfer from account " + fromAccount.getAccountId());
        }
    }

    public int getTotalBalance() {
        lock.lock();
        try {
            int totalBalance = 0;
            for (BankAccount account : accounts.values()) {
                totalBalance += account.getBalance();
            }
            return totalBalance;
        } finally {
            lock.unlock();
        }
    }
}
