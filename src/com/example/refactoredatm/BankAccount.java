package com.example.refactoredatm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    private Scanner userInput = new Scanner(System.in);
    private double balance;

    BankAccount(double startBalance) {
        balance = startBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public boolean hasEnoughToWithdraw(double amount) {
        return balance > amount;
    }

    public void printBalance() {
        System.out.println("\nYour balance is $" + balance);
    }

    public void promptAndWithdraw() {
        double withdrawAmount = getWithdrawAmount();
        if (validWithdraw(withdrawAmount)) {
            balance -= withdrawAmount;
        } else {
            if (withdrawAmount <= 0) {
                printWithdrawTooSmallMessage();
            } else {
                printInsufficientBalanceMessage();
            }
            promptAndWithdraw();
        }
    }

    private boolean validWithdraw(double withdrawAmount) {
        return hasEnoughToWithdraw(withdrawAmount) && withdrawAmount > 0;
    }


    private double getWithdrawAmount() {
        try {
            printWithdrawPrompt();
            return userInput.nextDouble();
        }
        catch (InputMismatchException e) {
            printInvalidAmountMessage();
            clearBuffer();
            return getWithdrawAmount();
        }
    }

    private void printWithdrawPrompt() {
        System.out.print("\nHow much would you like to withdraw?\n\n    $");
    }

    private void printInvalidAmountMessage() {
        System.out.println("\nSorry, I need a number.");
    }

    private void printWithdrawTooSmallMessage() {
        System.out.println("\nSorry, your withdraw cannot be less than $0");
    }

    private void printInsufficientBalanceMessage() {
        System.out.println("\nSorry, you don't have enough money.\n");
    }

    public void promptAndDeposit() {
        double depositAmount = getDepositAmount();
        if (validDeposit(depositAmount)) {
            balance += depositAmount;
        } else {
            printDepositTooSmallMessage();
            promptAndDeposit();
        }
    }

    private boolean validDeposit(double depositAmount) {
        return depositAmount > 0;
    }

    private double getDepositAmount() {
        try {
            printDepositPrompt();
            return userInput.nextDouble();
        }
        catch (InputMismatchException e) {
            printInvalidAmountMessage();
            clearBuffer();
            return getWithdrawAmount();
        }
    }

    private void printDepositPrompt() {
        System.out.print("\nHow much would you like to deposit?\n\n $");
    }

    private void printDepositTooSmallMessage() {
        System.out.println("\nSorry, your deposit cannot be less than $0");
    }

    private void clearBuffer() {
        userInput.nextLine();
    }
}
