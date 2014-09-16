package com.example.refactoredatm;

public class AtmDemo {
    BankAccount currentAccount = new BankAccount();

    public static void main(String[] args) {
        AtmInterface.promptForTransaction();
        System.out.print(AtmInterface.getTransactionNumber());
    }
}
