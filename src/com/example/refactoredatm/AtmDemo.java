package com.example.refactoredatm;

public class AtmDemo {
    BankAccount currentAccount = new BankAccount(1000);

    public static void main(String[] args) {
        BankAccount currentAccount = new BankAccount(1000);

        switch (AtmInterface.promptAndGetTransactionNumber()) {
            case 1: currentAccount.printBalance();
                break;
            case 2: currentAccount.promptAndWithdraw();
                break;
            case 3: currentAccount.promptAndDeposit();
        }
        currentAccount.printBalance();
    }
}
