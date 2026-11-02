package org.uni.lu;

import java.util.Random;

public class Drone {

    private double faultyChance;

    public int processUIView(UIView uiView) {
        if (faultyChance > 0) {
            if (RandomChecker.RandomValue() > faultyChance) {
                return (int) RandomChecker.RandomValue() * 100;
            }
        }
        return uiView.getFunction().solve();
    }

    public void setFaultyChance(double value) {
        assert value >= 0 && value <= 1.0;
        this.faultyChance = value;
    }
}
