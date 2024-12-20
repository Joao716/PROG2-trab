package Circuits.Components;

import java.util.HashMap;

import LogicCircuit.LCInputPin;

public class Component {
    private String id;
    private int x, y;
    private String legend;
    private HashMap<LCInputPin, Component> inputConnections;

    public Component(String id, int x, int y, String legend) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.legend = legend;
        this.inputConnections = new HashMap<>();
    }

    public HashMap<LCInputPin, Component> getInputConnections() {
        return inputConnections;
    }


}
