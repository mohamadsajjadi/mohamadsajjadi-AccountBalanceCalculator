package edu.sharif.selab;

import java.util.ArrayList;
import java.util.List;

public class AccountBalanceCalculator {

    private static List<Transaction> transactionHistory = new ArrayList<>();

    // Method to calculate balance based on transactions
    public static int calculateBalance(List<Transaction> transactions) {
        int balance = 0;
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                balance += t.getAmount();
            } else if (t.getType() == TransactionType.WITHDRAWAL) {
                balance -= t.getAmount();
            }

        }
        transactionHistory = new ArrayList<>(transactions);
        return balance;
    }

    // Method to get the transaction history
    public static List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy to prevent external modification
    }

    // Method to add a transaction to the history
    public static void addTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.WITHDRAWAL) {
            int newBalance = calculateBalance(transactionHistory) - transaction.getAmount();
            if (newBalance < 0){
//                throw new java.lang.RuntimeException("Not Enough Credit");
                System.out.println("Not Enough Credit !");
                return;
            }
        }
        transactionHistory.add(transaction);
    }

    // Method to clear the transaction history
    public static void clearTransactionHistory() {
        transactionHistory.clear();
    }
}
