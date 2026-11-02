package org.uni.lu;

import java.util.Random;

public class RandomChecker {

    private static final Random random = new Random();

    public static double RandomValue() {
        return random.nextDouble();
    }
}
