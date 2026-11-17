package org.uni.lu.devices;

import org.uni.lu.RandomChecker;

import java.util.Objects;

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

    public int returnFaultyResult(int realResult) {
        if (behaviourType != BehaviourType.WRONG_RESULT) {
            return realResult;
        }
        if (faultyChance > 0 && randomChecker.RandomValue() < faultyChance) {
            return (int) (randomChecker.RandomValue() * 100);
        }
        return realResult;
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
