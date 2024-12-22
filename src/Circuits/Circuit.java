package Circuits;

import Circuits.Components.Component;
import LogicCircuit.LCDPanel;

import java.util.HashMap;

public class Circuit {
    private HashMap<String, Component> circuits;
    private LCDPanel panel;

    public Circuit(LCDPanel panel) {
        this.panel = panel;
        circuits = new HashMap<>();
    }


    public void draw() {
        panel.clear();
        for (Component component : circuits.values()) {
            component.draw(panel);
            if (component instanceof )
        }

    }

}
