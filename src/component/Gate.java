package component;
import java.util.ArrayList;
public abstract class Gate extends Component{
    private TypeGate type;
    public Gate(){

    }
    public void setType(TypeGate t){
        type=t;
    }
    public abstract boolean compute(ArrayList<Boolean>list);
}