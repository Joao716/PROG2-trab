package Circuits.Components.Input;

import Circuits.Components.Component;
import Circuits.Components.State;
import LogicCircuit.*;

public class Gate extends HaveInput implements State {
    private boolean state;
    private LCComponent component;
    private Gates gate;

    public Gate(String id, int x, int y, String legend, String gateType) {
        super(id, x, y, legend);
        this.state = false;
        try {
            this.component = LCComponent.valueOf(gateType);
            this.gate = Gates.valueOf(gateType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid gate type: " + gateType);
        }
    }

    public boolean getState() {
        return state;
    }


    public void addInputConnection(String pin, Component component) {
        if (gate.maxInputs() > super.getInputConnections().size()) {
            super.getInputConnections().put(LCInputPin.valueOf(pin), component);
        } else {
            throw new IllegalStateException("Maximum number of inputs exceeded for gate: " + gate.name());
        }
    }

    public void draw(LCDPanel panel){
        if (super.getLegend().isBlank()) {
            panel.drawComponent(this.component, super.getX(), super.getY());
        } else {
            panel.drawComponent(this.component, super.getX(), super.getY(), super.getLegend());
        }
    }
}
