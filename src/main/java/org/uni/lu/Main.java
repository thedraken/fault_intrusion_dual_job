package org.uni.lu;

import java.util.List;
import java.util.stream.LongStream;

/**
 * Hello world!
 *
 */
public class Main {
    static void main(String[] args) {
        long faultyDevicesAllowed = 3;
        long numberOfDrones = faultyDevicesAllowed * 10;

        RandomChecker randomChecker = new RandomChecker();
        List<Drone> drones = LongStream.range(0, numberOfDrones).mapToObj(i -> new Drone(i, randomChecker)).toList();
        Network network = new Network(drones);

    }
}
