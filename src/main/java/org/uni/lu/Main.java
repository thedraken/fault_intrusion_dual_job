package org.uni.lu;

import org.uni.lu.drones.Behaviour;
import org.uni.lu.drones.Drone;

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
        Behaviour honestBehaviour = new Behaviour(Behaviour.BehaviourType.HONEST, randomChecker);


        List<Drone> drones = LongStream.range(0, numberOfDrones).mapToObj(i -> new Drone(i, honestBehaviour)).toList();
        Network network = new Network(drones);


    }
}
