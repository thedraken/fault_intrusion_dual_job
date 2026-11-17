package org.uni.lu.devices;

import org.uni.lu.AbstractSender;
import org.uni.lu.SenderType;
import org.uni.lu.messages.AbstractMessage;
import org.uni.lu.messages.ClientRequestMessage;

import java.util.HashSet;
import java.util.Set;

public class Drone extends AbstractSender {

    private final Behaviour behaviour;
    private final Set<AbstractMessage> messagesReceived;
    private Long sequenceCounter;

    public Drone(Long id, Behaviour startingBehaviour) {
        super(id, SenderType.DRONE);
        this.messagesReceived = new HashSet<>();
        this.behaviour = startingBehaviour;
    }

    public int processClientRequest(ClientRequestMessage clientRequestMessage) {
        this.messagesReceived.add(clientRequestMessage);
        int result = clientRequestMessage.getFunction().solve();
        return switch (this.behaviour.getBehaviourType()) {
            case HONEST, EQUIVOCATING, RANDOM_VOTES -> result;
            case SILENT ->
                //silence handling...
                //TODO handle silent result...
                    -1;
            case WRONG_RESULT -> this.behaviour.returnFaultyResult(result);
        };
    }

    public void setFaultyChance(double value) {
        this.behaviour.setFaultyChance(value);
    }

    public void updateBehaviour(Behaviour.BehaviourType behaviourType) {
        this.behaviour.setBehaviourType(behaviourType);
    }

    public Long getSequenceCounter() {
        return sequenceCounter;
    }

    public Set<AbstractMessage> getMessagesReceived() {
        return messagesReceived;
    }
}
