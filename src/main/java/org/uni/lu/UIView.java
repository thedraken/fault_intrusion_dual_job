package org.uni.lu;

public class UIView {

    private final Function function;
    private final Drone leaderDrone;

    public UIView(Function function, Drone leaderDrone) {
        this.function = function;
        this.leaderDrone = leaderDrone;
    }

    public Function getFunction() {
        return function;
    }

    public Drone getLeaderDrone() {
        return leaderDrone;
    }
}
