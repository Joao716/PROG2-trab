package Circuits.Components;

import LogicCircuit.*;

public abstract class Component {
    private String id;
    private int x, y;
    private String legend;
    private LCComponent component;

    public Component(String id, int x, int y, String legend, String componentName) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.legend = legend;
        try {
            this.component = LCComponent.valueOf(componentName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid component type: " + this.component.name());
        }
    }

    // Seters and Getters

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLegend() {
        return legend;
    }

    public LCComponent getComponent() {
        return component;
    }

    public abstract void draw(LCDPanel panel);
}
