package cmd_to_object;

import LogicCircuit.*;

public class Wire implements ToLiteral {
    private static final String pinA="PIN_A";
    private static final String pinB="PIN_B";
    private static final String pinC="PIN_C";
    private boolean error;
    private String id1;
    private String id2;
    private LCInputPin pin;

    public Wire() {
        error=false;
    }
    public boolean isError(){
        return error;
    }
    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public LCInputPin getPin() {
        return pin;
    }

    public void setPin(LCInputPin pin){
        this.pin = pin;
    }
    private boolean SpecialStringCompare(String str,String cmp){
        return str.toUpperCase().trim().equals(cmp);
    }
    private Object getObject(String str){
        if(SpecialStringCompare(str,pinA)){
            return LCInputPin.PIN_A;
        }else if(SpecialStringCompare(str,pinB)){
            return LCInputPin.PIN_B;
        }else if(SpecialStringCompare(str,pinC)){
            return LCInputPin.PIN_C;
        }else{
            return "Input pin \""+str+"\" invalid, it can either be "+pinA+ " or "+pinB+" or "+pinC+".\n";
        }
    }
    @Override
    public Object StringToLiteral(String input){
        String[]parts=input.split("\n");
        Wire res=new Wire();
        res.setId1(parts[0]);
        res.setId2(parts[1]);
        Object ty=getObject(parts[2]);
        if(ty instanceof String){
            error=true;
            return (String)ty;
        }else{
            res.setPin((LCInputPin)ty);
            return res;
        }
    }
}
