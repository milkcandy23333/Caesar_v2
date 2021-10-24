package com.milkcandy23333;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a Caesar encryption/decryption program");
        System.out.println("Press 1 to Encrypt or 2 to Decrypt");
        System.out.println("Press 3 to calculate a string's MD5");
        System.out.println("You can't Decrypt MD5,but you can press 4.");
        System.out.println();
        System.out.println("the priority: 1>2>3>4, for example:");
        System.out.println("When you input 12341234, we will run 11223344");
        System.out.println("When you input 2434, we will run 2344");

        Scanner scanner = new Scanner(System.in);
        String operator;
        String s;
        operator = scanner.nextLine();

        int pos = -1;

        do {
            pos = operator.indexOf("1", pos + 1);
            if (pos != -1) {
                CaesarEncryptioImpl X = new CaesarEncryptioImpl();
                s = X.encryptWizard();
                System.out.println(s);
            }
        } while (pos != -1);

        do {
            pos = operator.indexOf("2", pos + 1);
            if (pos != -1) {
                CaesarEncryptioImpl X = new CaesarEncryptioImpl();
                s = X.decryptWizard();
                System.out.println(s);
            }
        } while (pos != -1);

        do {
            pos = operator.indexOf("3", pos + 1);
            if (pos != -1) {
                Md5EncryptionImpl X = new Md5EncryptionImpl();
                s=X.encryptWizard();
                System.out.println(s);
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
