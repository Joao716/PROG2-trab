package Circuits.Components.Especialization;

import Circuits.Components.Component;
import Circuits.Components.Interfaces.InputConnection;
import LogicCircuit.LCInputPin;

public class OnlyInput extends Component implements InputConnection {
    public OnlyInput (String id, int x, int y, String legend) {
        super(id, x, y, legend);
    }

    public void addInputConnection(String pin, Component component) {
        super.getInputConnections().put(LCInputPin.valueOf(pin), component);
    }

    public void removeConnection(String pin, Component component){
        super.getInputConnections().remove(LCInputPin.valueOf(pin), component);
    }

    public void removeAllConnections(){
        super.getInputConnections().clear();
    }
}
