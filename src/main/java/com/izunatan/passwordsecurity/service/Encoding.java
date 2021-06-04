package com.izunatan.passwordsecurity.service;

import java.util.Base64;

public class Encoding {
    /*
    The purpose of encoding is to transform data so that it can be properly (and safely) consumed by a different
    type of system, e.g. binary data being sent over email, or viewing special characters on a web page.
    The goal is not to keep information secret, but rather to ensure that it’s able to be properly consumed.
    Encoding transforms data into another format using a scheme that is publicly available so that it can easily be reversed.
    It does not require a key as the only thing required to decode it is the algorithm that was used to encode it.

    ex: base64 encoding
     */

    public String encodeBase64Password(String normalPassword){
        String encodedPW;

        encodedPW = Base64.getEncoder().encodeToString(normalPassword.getBytes());

        return encodedPW;
    }

    public String decodeBase64Password(String encodedPassword){
        String decodedPW;

        decodedPW = new String(Base64.getDecoder().decode(encodedPassword));

        return decodedPW;
    }
}
