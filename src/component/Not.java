package component;
import java.util.ArrayList;
public class Not extends Gate{
    public Not(){
        super.setType(TypeGate.NOT);
    }
    @Override 
    public boolean compute(ArrayList<Boolean>list){
        try{
            return !list.get(0);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}