package component;
import java.util.ArrayList;
public class Nand extends Gate{
    public Nand(){
        super.setType(TypeGate.NAND);
    }
    @Override 
    public boolean compute(ArrayList<Boolean>list){
        try{
            return !(list.get(0)&&list.get(1));
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}