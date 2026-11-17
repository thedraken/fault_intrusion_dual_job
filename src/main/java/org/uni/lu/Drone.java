package org.uni.lu;

import java.util.HashSet;
import java.util.Set;

public class Drone extends AbstractSender {

    private double faultyChance;
    private final RandomChecker randomChecker;
    private final Set<UIView> uiViewsReceived;
    private Long sequenceCounter;
    private UIView currentView;

    public Drone(Long id, RandomChecker randomChecker) {
        super(id, SenderType.DRONE);
        this.randomChecker = randomChecker;
        this.uiViewsReceived = new HashSet<>();
    }

    public int processClientRequest(UIView uiView) {
        this.currentView = uiView;
        this.uiViewsReceived.add(uiView);

        if (faultyChance > 0) {
            if (randomChecker.RandomValue() < faultyChance) {
                return (int) (randomChecker.RandomValue() * 100);
            }
        }
        return uiView.getClientRequest().getFunction().solve();
    }

    public void setFaultyChance(double value) {
        assert value >= 0 && value <= 1.0;
        this.faultyChance = value;
    }

    public Long getSequenceCounter() {
        return sequenceCounter;
    }

    public Set<UIView> getUiViewsReceived() {
        return uiViewsReceived;
    }

    public UIView getCurrentView() {
        return currentView;
    }


}
