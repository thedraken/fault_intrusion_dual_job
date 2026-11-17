package org.uni.lu;

import java.util.Random;

public class RandomChecker {

    private final Random random;

    public RandomChecker() {
        random = new Random();
    }

    public RandomChecker(long seedValue) {
        random = new Random(seedValue);
    }

    public double RandomValue() {
        return random.nextDouble();
    }
}
