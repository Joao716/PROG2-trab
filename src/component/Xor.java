package component;
import java.util.ArrayList;
public class Xor extends Gate{
    public Xor(){
        super.setType(TypeGate.XOR);
    }
    @Override 
    public boolean compute(ArrayList<Boolean>list){
        try{
            return (list.get(0)||list.get(1))&&!(list.get(0)&&list.get(1));
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}