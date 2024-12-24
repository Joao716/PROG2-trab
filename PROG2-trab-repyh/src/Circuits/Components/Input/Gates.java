package Circuits.Components.Input;

import java.util.HashMap;

import Circuits.Components.Component;
import Circuits.Components.State;
import LogicCircuit.LCInputPin;

public enum Gates {
    NOT {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            for(Component component : connections.values()){
                if (component instanceof State){
                    return !(((State) component).getState());
                }
            }
            return false;
        }

        public int maxInputs () {
            return 1;
        }
    },
    AND {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            boolean state = true;
            for(Component component : connections.values()){
                if (component instanceof State){
                    state &= ((State) component).getState();
                }
            }
            return state;
        }

        public int maxInputs (){
            return 2;
        }
    },
    NAND {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            return !Gates.AND.calculateState(connections);
        }

        public int maxInputs (){
            return 2;
        }
    },
    OR {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            boolean state = false;
            for(Component component : connections.values()){
                if (component instanceof State){
                    state |= ((State) component).getState();
                }
            }
            return state;
        }

        public int maxInputs (){
            return 2;
        }
    },
    NOR {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            return !Gates.OR.calculateState(connections);
        }

        public int maxInputs (){
            return 2;
        }
    },
    XOR {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            boolean state = false;
            for(Component component : connections.values()){
                if (component instanceof State){
                    state ^= ((State) component).getState();
                }
            }
            return state;
        }

        public int maxInputs (){
            return 2;
        }
    },
    XNOR {
        public boolean calculateState (HashMap<LCInputPin, Component> connections){
            return !Gates.XOR.calculateState(connections);
        }

        public int maxInputs (){
            return 2;
        }
    };

    public abstract boolean calculateState (HashMap<LCInputPin, Component> connections);
    public abstract int maxInputs();
}
