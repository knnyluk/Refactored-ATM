package com.example.refactoredatm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmInterface {
    private static Scanner userInput = new Scanner(System.in);
    private static int lowValidOperationNumber = 1;
    private static int highValidOperationNumber = 3;

    public static void promptForTransaction() {
        System.out.print("\n" +
                "What would you like to do?\n" +
                "\n" +
                "  1.) Check account balance\n" +
                "  2.) Withdraw funds\n" +
                "  3.) Deposit funds\n\n");
    }

    public static int getTransactionNumber() {
        try {
            return userInput.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("\n Sorry, only " + lowValidOperationNumber + " - " + highValidOperationNumber + " are valid selections.");
            promptForTransaction();
            clearBuffer();
            return getTransactionNumber();
        }
    }

    private static void clearBuffer() {
        userInput.nextLine();
    }
}
