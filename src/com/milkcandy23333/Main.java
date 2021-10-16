package com.milkcandy23333;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("This is a Caesar encryption/decryption program");
            System.out.println("Press 1 to Encrypt or 2 to Decrypt");
            System.out.println("Press 3 to calculate a string's MD5");
            System.out.println("You can't Decrypt MD5,but you can press 4.");
            int operator, offset;
            String s;
            StringBuilder ans;
            operator = scanner.nextInt();

            if (operator == 1) {
                System.out.println("Step 1:Enter the string to encrypt.");
                s = scanner.nextLine();
                s = scanner.nextLine();
                System.out.println("Step 2:Enter the offset.");
                offset = scanner.nextInt();

                CaesarEncryption X = new CaesarEncryptioImpl();
                ans = X.encrypt(s, offset);

                System.out.println(ans);
            }
            if (operator == 2) {
                System.out.println("Step 1:Enter the string to decrypt.");
                s = scanner.nextLine();
                s = scanner.nextLine();
                System.out.println("Step 2:Enter the offset.");
                offset = scanner.nextInt();

                CaesarEncryption X = new CaesarEncryptioImpl();
                ans = X.decrypt(s, offset);

                System.out.println(ans);
            }
            if (operator == 3) {
                System.out.println("Enter the string to calculate MD5.");
                System.out.println("The length of the result is 32.");
                s = scanner.nextLine();
                s = scanner.nextLine();

                s = Md5Encryption.backMD5(s);

                System.out.println(s);
            }
            if (operator == 4) {
                Exception unsupported = new UnsupportedOperationException();
                unsupported.printStackTrace();
                System.out.println("UnsupportedOperationException");
                System.out.println("异常信息： MD5 算法无法解密");
            }
        }
    }
}
