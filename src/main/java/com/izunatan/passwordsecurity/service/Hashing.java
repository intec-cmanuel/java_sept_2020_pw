package com.izunatan.passwordsecurity.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    /*
    Hashing is an algorithm to map data of any size to a fixed length.
    A hash is not ‘encryption’ – it cannot be decrypted back to the original text (it is a ‘one-way’ cryptographic function,
    Whereas encryption is a two-way function, hashing is a one-way function.
    Hashing is used in conjunction with authentication to produce strong evidence that a given message
    has not been modified and serves the purpose of ensuring integrity, i.e.
    making it so that if something is changed you can know that it’s changed.

    ex. MD5 (OBSOLETE NEVER USE OR YOU ARE A DUMDUM)
     */

    public String hashingMD5(String normalPassword) {
        String hashedPW = "";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(normalPassword.getBytes());
            byte[] bytes = md.digest();

            /*
            %02x means print at least 2 digits, prepend it with 0's if there's less.
             */

            for (byte b : bytes) {
                String byteToString = String.format("%02X", b);
                hashedPW += byteToString;
            }

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {

        }

        return hashedPW.toLowerCase();
    }
}
