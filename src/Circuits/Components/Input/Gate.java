package Circuits.Components.Input;

import Circuits.Components.Component;
import Circuits.Components.State;
import LogicCircuit.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Gate extends HaveInput implements State {
    private boolean state;
    private Gates gate;

    public Gate(String id, int x, int y, String legend, String componentName) {
        super(id, x, y, legend, componentName);
        this.state = false;

        try {
            this.gate = Gates.valueOf(super.getComponent().name());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid gate type: " + super.getComponent().name());
        }
    }

    public boolean getState() {
        return state = gate.calculateState(super.getInputConnections());
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
            panel.drawComponent(
                    super.getComponent(),
                    super.getX(),
                    super.getY()
            );
        } else {
            panel.drawComponent(
                    super.getComponent(),
                    super.getX(),
                    super.getY(),
                    super.getLegend()
            );
        }
    }
}
