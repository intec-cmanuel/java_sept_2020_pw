package com.izunatan.passwordsecurity.service;

import java.util.Arrays;

public class Encryption {
    /*
    The purpose of encryption is to transform data to keep it secret from others,
    e.g. sending someone a secret letter that only they should be able to read, or securely sending a password over the Internet.
    Rather than focusing on usability, the goal is to ensure the data cannot be consumed by anyone other than the intended recipient(s)

    ex. CeaserShift
     */

    public String encryptCeaser(String normalPassword, int ceaserShift) {
        String encryptedPassword = "";

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] password = normalPassword.split("");
        for(int i = 0; i < normalPassword.length(); i++) {
            password[i] = alphabet[(indexOf(alphabet, password[i].charAt(0)) + ceaserShift) % alphabet.length];
        }

        return Arrays.stream(password).reduce("", (n, m) -> n + m);
    }

    private int indexOf(String[] sArr, char c){
        for (int i = 0; i < sArr.length; i++){
            if (sArr[i].equals("" + c)){
                return i;
            }
        }
        return -1;
    }

    public String decryptCeaser(String encryptedPassword, int ceaserShift) {
        String decryptedPassword = "";

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] password = encryptedPassword.split("");
        for(int i = 0; i < encryptedPassword.length(); i++) {
            password[i] = alphabet[(indexOf(alphabet, password[i].charAt(0)) - ceaserShift) % alphabet.length];
        }

        return Arrays.stream(password).reduce("", (n, m) -> n + m);
    }
}
