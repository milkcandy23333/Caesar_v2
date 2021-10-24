package com.milkcandy23333;

import java.util.Scanner;

public class CaesarEncryptioImpl implements CaesarEncryption, wizardInterface {
    private String result;
    private int offset;

    /**
     * encrypt/decrypt st,its offset is p
     * if p>0,a->b->c->d..
     * if p<0,d->c->b->a..
     *
     * @param st text
     * @param p  offset
     * @return ciphertext/original text
     */
    @Override
    public String getResult(String st, int p) {
        char thisCharacter;
        char numberOutOfBounds, letterOutOfBounds;
        int len = st.length();
        StringBuilder result = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            thisCharacter = st.charAt(i);
            numberOutOfBounds = (char) (st.charAt(i) + (p % 10));
            letterOutOfBounds = (char) (st.charAt(i) + (p % 26));

            if (st.charAt(i) >= '0' && st.charAt(i) <= '9') {
                if (numberOutOfBounds > '9') {
                    thisCharacter -= 10;
                }
                if (numberOutOfBounds < '0') {
                    thisCharacter += 10;
                }
                thisCharacter += (p % 10);
            } else if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                if (letterOutOfBounds > 'Z') {
                    thisCharacter -= 26;
                }
                if (letterOutOfBounds < 'A') {
                    thisCharacter += 26;
                }
                thisCharacter += (p % 26);
            } else if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
                if (letterOutOfBounds > 'z') {
                    thisCharacter -= 26;
                }
                if (letterOutOfBounds < 'a') {
                    thisCharacter += 26;
                }
                thisCharacter += (p % 26);
            } else if (st.charAt(i) >= 0x4e00 && st.charAt(i) <= 0x9fa5) {
                thisCharacter += p;
            }
            result.append(thisCharacter);
        }
        return result.toString();
    }

    /**
     * a Caesar encryption wizard
     *
     * @return the result of the encryption
     */
    @Override
    public String encryptWizard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Step 1:Enter the string to encrypt.");
        result = scanner.nextLine();
        System.out.println("Step 2:Enter the offset.");
        offset = scanner.nextInt();

        result = getResult(result, offset);
        return result;
    }

    /**
     * a Caesar decryption wizard
     *
     * @return the result of the decryption
     */
    @Override
    public String decryptWizard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Step 1:Enter the string to decrypt.");
        result = scanner.nextLine();
        System.out.println("Step 2:Enter the offset.");
        offset = scanner.nextInt();

        result = getResult(result, -offset);
        return result;
    }
}
