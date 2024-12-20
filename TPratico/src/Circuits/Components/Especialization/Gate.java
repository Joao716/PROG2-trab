package Circuits.Components.Especialization;

import Circuits.Components.Interfaces.InputConnection;
import Circuits.Components.Enuns.Gates;
import Circuits.Components.Component;
import LogicCircuit.LCInputPin;
import LogicCircuit.LCComponent;

public class Gate extends Component implements InputConnection {
    private boolean state;
    private LCComponent component;
    private Gates gate;

    public Gate(String id, int x, int y, String legend, String gateType) {
        super(id, x, y, legend);
        this.state = false;
        this.component = LCComponent.valueOf(gateType);
        this.gate = Gates.valueOf(gateType);
    }

    public boolean getState() {
        return state;
    }

    public void addInputConnection(String pin, Component component) {
        if (gate.totalInputs() < super.getInputConnections().size()){
            super.getInputConnections().put(LCInputPin.valueOf(pin), component);
        }
    }

    public void removeConnection(String pin, Component component){
        super.getInputConnections().remove(LCInputPin.valueOf(pin), component);
    }

    public void removeAllConnections(){
        super.getInputConnections().clear();
    }

}
