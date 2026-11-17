package org.uni.lu.drones;

import org.uni.lu.AbstractSender;
import org.uni.lu.SenderType;
import org.uni.lu.UIView;

import java.util.HashSet;
import java.util.Set;

public class Drone extends AbstractSender {

    private final Behaviour behaviour;
    private final Set<UIView> uiViewsReceived;
    private Long sequenceCounter;
    private UIView currentView;

    public Drone(Long id, Behaviour startingBehaviour) {
        super(id, SenderType.DRONE);
        this.uiViewsReceived = new HashSet<>();
        this.behaviour = startingBehaviour;
    }

    public int processClientRequest(UIView uiView) {
        this.currentView = uiView;
        this.uiViewsReceived.add(uiView);
        int result = uiView.getClientRequest().getFunction().solve();
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
        assert value >= 0 && value <= 1.0;
        this.behaviour.setFaultyChance(value);
    }

    public void updateBehaviour(Behaviour.BehaviourType behaviourType) {
        this.behaviour.setBehaviourType(behaviourType);
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
