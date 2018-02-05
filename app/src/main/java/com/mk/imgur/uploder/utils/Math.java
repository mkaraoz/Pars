package com.mk.imgur.uploder.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by mk on 28.01.2018.
 */

public class Math
{
    public static int getRandomNumberBetween(final int min, final int max)
    {
        Random r = new SecureRandom();
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
