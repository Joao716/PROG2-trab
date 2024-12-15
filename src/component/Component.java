package component;
import logicircuit.*;
import java.util.HashMap;
import java.util.HashSet;
public class Component{
    private String id;
    private LCComponent comp;
    private String legend;
    private HashMap<ConnectionType,HashSet<Component>> connections;
    private int x;
    private int y; 
    public Component(){
        
    }
}