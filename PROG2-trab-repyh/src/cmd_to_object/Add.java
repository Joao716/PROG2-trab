package cmd_to_object;
import Circuits.Components.Input.Gates;
import LogicCircuit.*;
public class Add implements ToLiteral{
    private static final String sw="SWITCH";
    private static final String bit3="3BD";
    private static final String and="AND";
    private static final String or="OR";
    private static final String nand="NAND";
    private static final String nor="NOR";
    private static final String xor="XOR";
    private static final String not="NOT";
    private static final String led="LED";
    //
    private boolean error;
    private String id;
    private Object type;
    private int x;
    private int y;
    private String legend;
    public Add() {
        error=false;
    }
    public boolean isError(){return error;}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }
    private boolean SpecialStringCompare(String str,String cmp){
        return str.toUpperCase().trim().equals(cmp);
    }
    private Object getObject(String str){
        if(SpecialStringCompare(str,sw)){
            return LCComponent.SWITCH;
        }else if(SpecialStringCompare(str,bit3)){
            return LCComponent.BIT3_DISPLAY;
        }else if(SpecialStringCompare(str,and)){
            return Gates.AND;
        }else if(SpecialStringCompare(str,or)){
            return Gates.OR;
        }else if(SpecialStringCompare(str,nand)){
            return Gates.NAND;
        }else if(SpecialStringCompare(str,nor)){
            return Gates.NOR;
        }else if(SpecialStringCompare(str,xor)){
            return Gates.XOR;
        }else if(SpecialStringCompare(str,not)){
            return Gates.NOT;
        }else if(SpecialStringCompare(str,led)){
            return LCComponent.LED;
        }else{
            return str+" was not identified as any valid component for ADD command :(";
        }
    }
    @Override
    public Object StringToLiteral(String input){
        String errorMessage="";
        boolean errorDetected=false;
        Add res=new Add();
        String[]parts=input.split("\n");
        res.setId(parts[0]);
        Object ty=new Object();
        ty=getObject(parts[1]);
        res.setType(ty);
        if(ty instanceof String){
            errorMessage+=(String)ty;
            errorMessage+="\n";
            errorDetected=true;
        }
        try{
            x=Integer.parseInt(parts[2]);
            res.setX(x);
        }catch(Exception e){
            errorMessage+="value "+parts[2]+" for coordinate X not an integer\n";
            errorDetected=true;
        }
        try{
            y=Integer.parseInt(parts[3]);
            res.setY(y);
        }catch(Exception e){
            errorMessage+="value "+parts[3]+" for coordinate Y not an integer\n";
            errorDetected=true;
        }
        res.setLegend(parts[4]);
        if(errorDetected){
            error=true;
            return errorMessage;
        }else{
            return res;
        }
    }
}
