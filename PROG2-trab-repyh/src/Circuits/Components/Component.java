package Circuits.Components;

import java.util.HashMap;

import LogicCircuit.*;

public abstract class Component {
    private String id;
    private int x, y;
    private String legend;

    public Component(String id, int x, int y, String legend) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.legend = legend;
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

    public abstract void draw(LCDPanel panel);


}
