package Circuits.Components.Input;

import Circuits.Components.*;
import LogicCircuit.LCComponent;
import LogicCircuit.LCDPanel;
import LogicCircuit.LCInputPin;

import java.util.HashMap;
import java.util.Map;

public abstract class HaveInput extends Component {
    private HashMap<LCInputPin, Component> inputConnections;

    public HaveInput(String id, int x, int y, String legend, String componentName) {
        super(id, x, y, legend, componentName);
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

    public void drawWire(LCDPanel panel) {
        for (Map.Entry<LCInputPin, Component> entry : inputConnections.entrySet()) {
            Component component = entry.getValue();
            LCInputPin key = entry.getKey();

            if (component instanceof State) {
                panel.drawWire(
                        super.getComponent(),
                        super.getX(),
                        super.getY(),
                        component.getComponent(),
                        component.getX(),
                        component.getY(),
                        key,
                        ((State) component).getState()
                );
            }
        }
    }
}
