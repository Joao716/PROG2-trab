package Circuits.Components.Output;

import Circuits.Components.*;
import LogicCircuit.*;

public class Switch extends Component implements State {
    private static final LCComponent component = LCComponent.SWITCH;
    private boolean state;

    public Switch(String id, int x, int y, String legend) {
        super(id, x, y, legend);
        state = false;
    }

    public boolean getState() {
        return state;
    }

    public void draw(LCDPanel panel){
        if (super.getLegend().isBlank()) {
            panel.drawComponent(this.component, super.getX(), super.getY());
        } else {
            panel.drawComponent(this.component, super.getX(), super.getY(), super.getLegend());
        }
    }


}
