package com.milkcandy23333;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 -> Caesar Encrypt");
        System.out.println("2 -> Caesar Decrypt");
        System.out.println("3 -> Calc. a string's MD5");
        System.out.println("4 -> Decrypt MD5(Unsupported)");
        System.out.println();
        System.out.println("the priority: 1>2>3>4, for example:");
        System.out.println("When you input 12341234, we will run 11223344");
        System.out.println("When you input 41221334, we will run 11223344");

        Scanner scanner = new Scanner(System.in);
        String operator;
        operator = scanner.nextLine();

        int pos = -1;

        do {
            pos = operator.indexOf("1", pos + 1);
            if (pos != -1) {
                CaesarEncryptioImpl X = new CaesarEncryptioImpl();
                System.out.println(X.encryptWizard());
            }
        } while (pos != -1);

        do {
            pos = operator.indexOf("2", pos + 1);
            if (pos != -1) {
                CaesarEncryptioImpl X = new CaesarEncryptioImpl();
                System.out.println(X.decryptWizard());
            }
        } while (pos != -1);

        do {
            pos = operator.indexOf("3", pos + 1);
            if (pos != -1) {
                Md5EncryptionImpl X = new Md5EncryptionImpl();
                System.out.println(X.encryptWizard());
            }
        } while (pos != -1);

        do {
            pos = operator.indexOf("4", pos + 1);
            if (pos != -1) {
                Md5EncryptionImpl X = new Md5EncryptionImpl();
                X.decryptWizard();
            }
        } while (pos != -1);

        System.out.println("This program has finished its tasks.^_^");
    }
}
