package Circuits.Components.Enuns;

import java.util.HashMap;
import java.util.HashSet;

import Circuits.Components.Component;
import Circuits.Components.Especialization.Gate;

public enum Gates {

    NOT {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            for(Component x : connections.get(TypeConnection.INPUT)){
                if (x instanceof Gate){
                    return !((Gate) x).getState();
                }
            }
            return false;
        };

        public int totalInputs (){
            return 1;
        }
    },
    AND {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            boolean state = true;
            for(Component x : connections.get(TypeConnection.INPUT)){
                if (x instanceof Gate){
                   state &= ((Gate) x).getState();
                }
            }
            return state;
        };

        public int totalInputs (){
            return 2;
        }
    },
    NAND {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            return !Gates.AND.calculateState(connections);
        };

        public int totalInputs (){
            return 2;
        }
    },
    OR {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            boolean state = false;
            for(Component x : connections.get(TypeConnection.INPUT)){
                if (x instanceof Gate){
                    state |= ((Gate) x).getState();
                }
            }
            return state;
        };

        public int totalInputs (){
            return 2;
        }
    },
    NOR {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            return !Gates.OR.calculateState(connections);
        };

        public int totalInputs (){
            return 2;
        }
    },
    XOR {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            boolean state = false;
            for(Component x : connections.get(TypeConnection.INPUT)){
                if (x instanceof Gate){
                    state ^= ((Gate) x).getState();
                }
            }
            return state;
        };

        public int totalInputs (){
            return 2;
        }
    },
    XNOR {
        public boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections){
            return !Gates.XOR.calculateState(connections);
        };

        public int totalInputs (){
            return 2;
        }
    };

    public abstract boolean calculateState(HashMap<TypeConnection, HashSet<Component>> connections);
    public abstract int totalInputs();

}
