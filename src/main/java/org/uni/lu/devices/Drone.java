package org.uni.lu.devices;

import org.uni.lu.AbstractSender;
import org.uni.lu.SenderType;
import org.uni.lu.messages.AbstractMessage;

import java.util.HashSet;
import java.util.Set;

public class Drone extends AbstractSender {

    private final Behaviour behaviour;
    private final Set<AbstractMessage> messagesReceived;
    private Long sequenceCounter = 0L;

    public Drone(Long id, Behaviour startingBehaviour) {
        super(id, SenderType.DRONE);
        this.messagesReceived = new HashSet<>();
        this.behaviour = startingBehaviour;
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

    public Behaviour getBehaviour() {
        return behaviour;
    }
}
