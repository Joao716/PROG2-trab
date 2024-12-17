package component;
import java.util.ArrayList;
public class And extends Gate{
    public And(){
        super.setType(TypeGate.AND);
    }
    @Override 
    public boolean compute(ArrayList<Boolean>list){
        try{
            return list.get(0)&&list.get(1);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}