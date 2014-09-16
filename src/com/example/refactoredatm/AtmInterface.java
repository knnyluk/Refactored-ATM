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
            int transactionNum = userInput.nextInt();
            if (isInvalidOperationNum(transactionNum)) {
                printOutOfRangeOperationMessage();
                promptForTransaction();
                return getTransactionNumber();
            } else {
                return transactionNum;
            }

        }
        catch (InputMismatchException e) {
            printOutOfRangeOperationMessage();
            promptForTransaction();
            clearBuffer();
            return getTransactionNumber();
        }
    }

    private static void printOutOfRangeOperationMessage() {
        System.out.println("\n Sorry, only " + lowValidOperationNumber + " - " + highValidOperationNumber + " are valid selections.");
    }

    private static boolean isInvalidOperationNum(int operationNumber) {
        return operationNumber < lowValidOperationNumber || operationNumber > highValidOperationNumber;
    }

    private static void clearBuffer() {
        userInput.nextLine();
    }
}
