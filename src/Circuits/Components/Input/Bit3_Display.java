package Circuits.Components.Input;

import Circuits.Components.Component;
import LogicCircuit.*;

public class Bit3_Display extends HaveInput {
    private static final int maxInput = 3;
    private static final LCComponent component = LCComponent.BIT3_DISPLAY;

    private int value;

    public Bit3_Display(String id, int x, int y, String legend) {
        super(id, x, y, legend);
        this.value = 0;
    }

    public void addInputConnection(String pin, Component component) {
        if (maxInput > super.getInputConnections().size()) {
            super.getInputConnections().put(LCInputPin.valueOf(pin), component);
        } else {
            throw new IllegalStateException("Maximum number of inputs exceeded for gate: " + super.getId());
        }
    }

    public void draw(LCDPanel panel){
        panel.drawComponent(this.component, super.getX(), super.getY(), value);
    }
}
