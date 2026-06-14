package com.gowri.breachguard.util;

import java.security.MessageDigest;

public class Sha1Util {

    public static String sha1(String uPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashVal = md.digest(uPassword.getBytes());
            StringBuilder pass = new StringBuilder();
            for (byte b : hashVal) {
                pass.append(String.format("%02x", b));
            }
            return pass.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while generating SHA-1 hash", e);
        }
    }
}
