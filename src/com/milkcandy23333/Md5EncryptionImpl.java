package com.milkcandy23333;

import java.security.MessageDigest;
import java.util.Scanner;

public class Md5EncryptionImpl implements Md5Encryption, wizardInterface {
    private String result;

    /**
     * calculate a string's MD5 code
     *
     * @param inStr text
     * @return MD5 code
     */
    public String getResult(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            return "";
        }

        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {

            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    /**
     * an MD5 encrypt wizard
     *
     * @return MD5 code
     */
    public String encryptWizard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string to calculate MD5.");
        System.out.println("The length of the result is 32.");
        result = scanner.nextLine();

        return getResult(result);
    }

    /**
     * an MD5 decrypt wizard
     *
     * @return nothing
     */
    public String decryptWizard() {
        try {
            Exception unsupported = new UnsupportedOperationException();
            unsupported.printStackTrace();
        } catch (Exception unsupported) {
            unsupported.printStackTrace();
            System.out.println("md5不能解密");
        }
        return null;
    }
}
