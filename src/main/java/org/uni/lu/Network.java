package org.uni.lu;

import org.uni.lu.devices.Drone;
import org.uni.lu.messages.AbstractMessage;
import org.uni.lu.messages.ReplyMessage;

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

    public void send(AbstractSender fromDevice, Drone sendToDrone, AbstractMessage message) {
        queuedMessages.putIfAbsent(sendToDrone, new LinkedList<>());
        updateMessageSignature(fromDevice, message);
        queuedMessages.get(sendToDrone).add(message);
    }

    public void broadcast(AbstractSender fromDevice, AbstractMessage message) {
        updateMessageSignature(fromDevice, message);
        queuedMessages.forEach((k, v) -> {
            if (k.getSenderType() == SenderType.DRONE) {
                v.add(message);
            }
        });
    }

    public void replyToClient(AbstractSender fromDevice, ReplyMessage replyMessage) {
        updateMessageSignature(fromDevice, replyMessage);
        queuedMessages.forEach((k, v) -> {
            if (k.getSenderType().equals(SenderType.CLIENT)) {
                v.add(replyMessage);
            }
        });
    }

    private void updateMessageSignature(AbstractSender fromDevice, AbstractMessage message) {
        message.setSenderId(fromDevice.getId());
        message.setSenderType(fromDevice.getSenderType());
    }
}
