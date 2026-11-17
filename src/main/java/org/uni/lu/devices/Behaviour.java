package org.uni.lu.devices;

import org.uni.lu.Main;
import org.uni.lu.RandomChecker;

import java.util.Objects;

public class Behaviour {
    private final RandomChecker randomChecker;
    private double faultyChance;
    private BehaviourType behaviourType;

    public Behaviour(BehaviourType behaviourType, RandomChecker randomChecker) {
        this.behaviourType = behaviourType;
        this.randomChecker = randomChecker;
    }

    public BehaviourType getBehaviourType() {
        return behaviourType;
    }

    public void setBehaviourType(BehaviourType behaviourType) {
        this.behaviourType = behaviourType;
        if (Objects.requireNonNull(behaviourType) == BehaviourType.WRONG_RESULT) {
            this.faultyChance = Main.faultyChance;
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

    public void setFaultyChance(double faultyChance) {
        if (faultyChance >= 0 && faultyChance <= 1.0) {
            if (faultyChance > 0) {
                this.behaviourType = BehaviourType.WRONG_RESULT;
            }
            this.faultyChance = faultyChance;
        } else {
            throw new IllegalArgumentException("Faulty chance can only be between 0 and 1.0, but received " + faultyChance);
        }
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
