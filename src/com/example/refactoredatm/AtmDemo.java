package com.example.refactoredatm;

public class AtmDemo {

    public static void main(String[] args) {
        AtmInterface.promptForTransaction();
        System.out.print(AtmInterface.getTransactionNumber());
    }
}
