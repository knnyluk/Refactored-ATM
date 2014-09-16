package com.example.refactoredatm;

public class AtmDemo {
    BankAccount currentAccount = new BankAccount(1000);

    public static void main(String[] args) {
        BankAccount currentAccount = new BankAccount(1000);

//        System.out.print(AtmInterface.promptAndGetTransactionNumber());
        switch (AtmInterface.promptAndGetTransactionNumber()) {
            case 1: currentAccount.printBalance();
                break;
            case 2: currentAccount.promptAndWithdraw();
                break;
        }
        currentAccount.printBalance();
    }
}
