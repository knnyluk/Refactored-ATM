package com.example.refactoredatm;

import java.util.Scanner;

public class AtmDemo {
    private Scanner userInput = new Scanner(System.in);

    BankAccount currentAccount = new BankAccount(1000);

    public static void main(String[] args) {
        BankAccount currentAccount = new BankAccount(1000);
        do {
            switch (AtmInterface.promptAndGetTransactionNumber()) {
                case 1:
                    currentAccount.printBalance();
                    break;
                case 2:
                    currentAccount.promptAndWithdraw();
                    break;
                case 3:
                    currentAccount.promptAndDeposit();
            }
        } while (AtmInterface.wantToContinue());
    }
}
