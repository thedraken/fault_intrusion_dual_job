package org.uni.lu.devices;

import org.uni.lu.AbstractSender;
import org.uni.lu.Network;
import org.uni.lu.RandomChecker;
import org.uni.lu.messages.AbstractMessage;
import org.uni.lu.messages.CommitMessage;
import org.uni.lu.messages.PrepareMessage;
import org.uni.lu.messages.ReplyMessage;

import java.util.Objects;
import java.util.Optional;

public class Behaviour {
    private final RandomChecker randomChecker;
    private double faultyChance;
    private final double globalFaultyChance;
    private BehaviourType behaviourType;

    public Behaviour(BehaviourType behaviourType, RandomChecker randomChecker, double globalFaultyChance) {
        this.behaviourType = behaviourType;
        this.randomChecker = randomChecker;
        this.globalFaultyChance = globalFaultyChance;
    }

    public BehaviourType getBehaviourType() {
        return behaviourType;
    }

    public void setBehaviourType(BehaviourType behaviourType) {
        this.behaviourType = behaviourType;
        if (Objects.requireNonNull(behaviourType) == BehaviourType.WRONG_RESULT) {
            this.faultyChance = globalFaultyChance;
        } else {
            this.faultyChance = 0;
        }
    }

    public Optional<AbstractMessage> apply(Network network, AbstractSender to, AbstractMessage message) {
        switch (this.behaviourType) {
            case SILENT -> {
                return Optional.empty();
            }
            case WRONG_RESULT -> {
                if (message instanceof ReplyMessage replyMessage) {
                    if (randomChecker.RandomValue() > faultyChance) {
                        return Optional.of(new ReplyMessage(replyMessage.getMessageId(),
                                replyMessage.getTimeStamp(),
                                replyMessage.getSenderId(),
                                replyMessage.getSenderType(),
                                replyMessage.getViewId(),
                                replyMessage.getSequenceNumber(),
                                replyMessage.getDigest(),
                                replyMessage.getClientId(),
                                replyMessage.getReplicaId(),
                                (int) (randomChecker.RandomValue() * 100)
                        ));
                    }
                }
            }
            case RANDOM_VOTES -> {
                if (message instanceof PrepareMessage prepareMessage) {
                    return Optional.of(new PrepareMessage(prepareMessage.getMessageId(),
                            prepareMessage.getTimeStamp(),
                            prepareMessage.getSenderId(),
                            prepareMessage.getSenderType(),
                            prepareMessage.getViewId(),
                            prepareMessage.getSequenceNumber(),
                            "",
                            prepareMessage.getReplicaId()));
                } else if (message instanceof CommitMessage commitMessage) {
                    return Optional.of(new CommitMessage(commitMessage.getMessageId(),
                            commitMessage.getTimeStamp(),
                            commitMessage.getSenderId(),
                            commitMessage.getSenderType(),
                            commitMessage.getViewId(),
                            commitMessage.getSequenceNumber(),
                            "",
                            commitMessage.getReplicaId()));
                }
            }
        }
        return Optional.of(message);
    }

    public enum BehaviourType {
        HONEST,
        SILENT,
        WRONG_RESULT,
        //a primary that sends different PrePrepareMessage to different backups
        EQUIVOCATING,
        RANDOM_VOTES
    }
}
