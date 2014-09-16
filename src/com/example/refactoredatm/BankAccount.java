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
        if (hasEnoughToWithdraw(withdrawAmount)) {
            balance -= withdrawAmount;
        } else {
            printInsufficientBalanceMessage();
            promptAndWithdraw();
        }
    }

    private double getWithdrawAmount() {
        try {
            printWithdrawPrompt();
            return userInput.nextDouble();
        }
        catch (InputMismatchException e) {
            printInvalidAmountMessage();
            return getWithdrawAmount();
        }
    }

    private void printWithdrawPrompt() {
        System.out.print("\nHow much would you like to withdraw?\n\n$");
    }

    private void printInvalidAmountMessage() {
        System.out.println("\nSorry, I need a number.");
    }

    private void printInsufficientBalanceMessage() {
        System.out.println("\nSorry, you don't have enough money.\n");
    }
}
