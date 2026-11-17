package org.uni.lu;

import org.uni.lu.devices.Drone;
import org.uni.lu.messages.AbstractMessage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Network {

    private final HashMap<AbstractSender, LinkedList<AbstractMessage>> queuedMessages;

    public Network() {
        this.queuedMessages = new HashMap<>();
    }

    public Network(List<AbstractSender> senders) {
        this.queuedMessages = new HashMap<>();
        senders.forEach(sender -> this.queuedMessages.putIfAbsent(sender, new LinkedList<>()));
    }

    public void send(AbstractSender fromDevice, AbstractSender sendToDevice, AbstractMessage message) {
        queuedMessages.putIfAbsent(sendToDevice, new LinkedList<>());
        if (fromDevice instanceof Drone drone) {
            queuedMessages.get(sendToDevice).add(drone.getBehaviour().apply(this, sendToDevice, message).orElse(null));
        } else {
            queuedMessages.get(sendToDevice).add(message);
        }
    }

    public void broadcast(AbstractSender fromDevice, AbstractMessage message) {
        queuedMessages.forEach((k, v) -> {
            if (k.getSenderType() == SenderType.DRONE) {
                if (fromDevice instanceof Drone drone) {
                    v.add(drone.getBehaviour().apply(this, k, message).orElse(null));
                } else {
                    v.add(message);
                }
            }
        });
    }
}
