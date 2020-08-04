package com.reimia.fanxing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class FanXing {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
        byte[] bytes = instanceStrong.generateSeed(1);
        System.out.println(Arrays.toString(bytes));

    }
}
