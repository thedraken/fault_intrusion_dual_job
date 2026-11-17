package org.uni.lu;

import org.uni.lu.drones.Drone;
import org.uni.lu.messages.AbstractMessage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Network {

    private final HashMap<Drone, LinkedList<AbstractMessage>> queuedMessages;

    public Network() {
        this.queuedMessages = new HashMap<>();
    }

    public Network(List<Drone> drones) {
        this.queuedMessages = new HashMap<>();
        drones.forEach(drone -> this.queuedMessages.putIfAbsent(drone, new LinkedList<>()));
    }

    public void send(AbstractSender fromDevice, Drone sendToDrone, AbstractMessage message) {
        queuedMessages.putIfAbsent(sendToDrone, new LinkedList<>());
        updateMessageSignature(fromDevice, message);
        queuedMessages.get(sendToDrone).add(message);
    }

    public void broadcast(AbstractSender fromDevice, AbstractMessage message) {
        updateMessageSignature(fromDevice, message);
        queuedMessages.values().forEach(v -> v.add(message));
    }

    private void updateMessageSignature(AbstractSender fromDevice, AbstractMessage message) {
        message.setSenderId(fromDevice.getId());
        message.setSenderType(fromDevice.getSenderType());
    }
}
