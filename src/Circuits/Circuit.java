package Circuits;

import Circuits.Components.Component;
import Circuits.Components.Input.HaveInput;
import LogicCircuit.LCDPanel;

import java.util.HashMap;

public class Circuit {
    private HashMap<String, Component> circuits;
    private LCDPanel panel;

    public Circuit(LCDPanel panel) {
        this.panel = panel;
        circuits = new HashMap<>();
    }

    public void addComponent(String name, Component component) {
        circuits.put(name, component);
    }

    public void removeComponent(String name) {
        for (Component component : circuits.values()) {
            if (component instanceof HaveInput) {
                ((HaveInput) component).getInputConnections().remove(name);
            }
        }
        circuits.remove(name);
    }

    public void removeAllComponents() {
        circuits.clear();
    }

    public void draw() {
        panel.clear();
        for (Component component : circuits.values()) {
            component.draw(panel);
            if (component instanceof HaveInput){
                ((HaveInput) component).drawWire(panel);
            }
        }
    }
}
