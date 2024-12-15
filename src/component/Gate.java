package component;
import java.util.ArrayList;
public class Gate extends Component{
    private TypeGate type;
    public Gate(){

    }
    public void setType(TypeGate t){
        type=t;
    }
    public TypeGate getType(){
        return type;
    }
    private boolean Xor(boolean p,boolean q){
        return (p||q)&&!(p&&q);
    } 
    public boolean compute(ArrayList<Boolean>list){
        int i;boolean result=false;
        switch(this.type){
            case NOT:
                return !list.get(0);
            case AND:
                for(i=0;i<list.size()-1;i++){
                    result=list.get(i);
                    result&=list.get(i+1);
                }
                return result;
            case OR:
                for(i=0;i<list.size()-1;i++){
                    result=list.get(i);
                    result|=list.get(i+1);
                }
                return result;
            case XOR:
                for(i=0;i<list.size()-1;i++){
                    result=list.get(i);
                    result=Xor(result,list.get(i+1));
                }
                return result;
            case NOR:
                for(i=0;i<list.size()-1;i++){
                    result=list.get(i);
                    result=!(result || list.get(i+1));
                }
                return result;
            case NAND:
                for(i=0;i<list.size()-1;i++){
                    result=list.get(i);
                    result=!(result && list.get(i+1));
                }
                return result;
            default:
                return false;
        }
    }
}