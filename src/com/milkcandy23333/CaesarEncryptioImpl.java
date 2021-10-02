package com.milkcandy23333;

public class CaesarEncryptioImpl implements CaesarEncryption {
    public String Encrypt(String st, int p) {
        String ret = "";
        int tmp;
        int len = st.length();
        for (int i = 0; i < len; i++) {
            tmp = st.charAt(i);

            if (st.charAt(i) >= '0' && st.charAt(i) <= '9') {
                if (st.charAt(i) + (p % 10) > '9')
                    tmp -= 10;
                tmp += (p % 10);
            }
            if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                if (st.charAt(i) + (p % 26) > 'Z')
                    tmp -= 26;
                tmp += (p % 26);
            }
            if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
                if (st.charAt(i) + (p % 26) > 'z')
                    tmp -= 26;
                tmp += (p % 26);
            }
            if (st.charAt(i) >= 0x4e00 && st.charAt(i) <= 0x9fa5) {
                tmp += p;
            }

            ret = ret + (char) tmp;
        }
        return ret;
    }

    public String Decrypt(String st, int p) {
        String ret = "";
        int tmp;
        int len = st.length();
        for (int i = 0; i < len; i++) {
            tmp = st.charAt(i);

            if (st.charAt(i) >= '0' && st.charAt(i) <= '9') {
                if (st.charAt(i) - (p % 10) < '0')
                    tmp += 10;
                tmp -= (p % 10);
            }
            if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                if (st.charAt(i) - (p % 26) < 'A')
                    tmp += 26;
                tmp -= (p % 26);
            }
            if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
                if (st.charAt(i) - (p % 26) < 'a')
                    tmp += 26;
                tmp -= (p % 26);
            }
            if (st.charAt(i) >= 0x4e00 && st.charAt(i) <= 0x9fa5) {
                tmp -= p;
            }

            ret = ret + (char) tmp;
        }
        return ret;
    }
}
