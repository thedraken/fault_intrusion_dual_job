package org.uni.lu;

import org.uni.lu.devices.Behaviour;
import org.uni.lu.devices.Client;
import org.uni.lu.devices.Drone;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class Main {

    public static final long faultyDevicesAllowed = 1;
    public static final double faultyChance = 0.5;

    static void main(String[] args) {

        long numberOfDrones = (3 * faultyDevicesAllowed) + 1;

        RandomChecker randomChecker = new RandomChecker();


        List<AbstractSender> devices = LongStream.range(0, numberOfDrones)
                .mapToObj(i -> new Drone(i, new Behaviour(Behaviour.BehaviourType.HONEST, randomChecker)))
                .collect(Collectors.toList());
        devices.add(new Client(0L));

        Network network = new Network(devices);
    }
}
