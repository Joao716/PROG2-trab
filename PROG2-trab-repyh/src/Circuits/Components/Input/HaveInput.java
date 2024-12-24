package Circuits.Components.Input;

import Circuits.Components.*;
import LogicCircuit.LCInputPin;

import java.util.HashMap;

public abstract class HaveInput extends Component {
    private HashMap<LCInputPin, Component> inputConnections;

    public HaveInput(String id, int x, int y, String legend) {
        super(id, x, y, legend);
        inputConnections = new HashMap<>();
    }

    public HashMap<LCInputPin, Component> getInputConnections() {
        return inputConnections;
    };

    public abstract void addInputConnection(String pin, Component component);

    public void removeConnection(String pin) {
        if (pin == null || !getInputConnections().containsKey(LCInputPin.valueOf(pin))) {
            return;
        }
        getInputConnections().remove(LCInputPin.valueOf(pin));
    }


    public void removeAllConnections(){
        getInputConnections().clear();
    }

}
