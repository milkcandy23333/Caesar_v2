package com.milkcandy23333;

public class CaesarEncryptioImpl implements CaesarEncryption {
    @Override
    public StringBuilder encrypt(String st, int p) {
        StringBuilder result = new StringBuilder(1 << 10);
        int thisCharacter;
        int len = st.length();
        for (int i = 0; i < len; i++) {
            thisCharacter = st.charAt(i);

            if (st.charAt(i) >= '0' && st.charAt(i) <= '9') {
                if (st.charAt(i) + (p % 10) > '9') {
                    thisCharacter -= 10;
                }
                thisCharacter += (p % 10);
            }
            if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                if (st.charAt(i) + (p % 26) > 'Z') {
                    thisCharacter -= 26;
                }
                thisCharacter += (p % 26);
            }
            if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
                if (st.charAt(i) + (p % 26) > 'z') {
                    thisCharacter -= 26;
                }
                thisCharacter += (p % 26);
            }
            if (st.charAt(i) >= 0x4e00 && st.charAt(i) <= 0x9fa5) {
                thisCharacter += p;
            }

            result.append((char) thisCharacter);
        }
        return result;
    }

    @Override
    public StringBuilder decrypt(String st, int p) {
        StringBuilder result = new StringBuilder(1 << 10);
        int thisCharacter;
        int len = st.length();
        for (int i = 0; i < len; i++) {
            thisCharacter = st.charAt(i);

            if (st.charAt(i) >= '0' && st.charAt(i) <= '9') {
                if (st.charAt(i) - (p % 10) < '0') {
                    thisCharacter += 10;
                }
                thisCharacter -= (p % 10);
            }
            if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                if (st.charAt(i) - (p % 26) < 'A') {
                    thisCharacter += 26;
                }
                thisCharacter -= (p % 26);
            }
            if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
                if (st.charAt(i) - (p % 26) < 'a') {
                    thisCharacter += 26;
                }
                thisCharacter -= (p % 26);
            }
            if (st.charAt(i) >= 0x4e00 && st.charAt(i) <= 0x9fa5) {
                thisCharacter -= p;
            }

            result.append((char) thisCharacter);
        }
        return result;
    }
}
