package commands;
import logicircuit.*;
public class P_open implements CmdProcessor{
    private boolean error;
    public P_open(){
        error=false;
    }
    public boolean isError(){return error;}
    @Override
    public String process(String text){
        String[]parts=text.split(" ");
        boolean notEnoughArgs=(parts.length!=2);
        if(!notEnoughArgs){
            return parts[1].trim();
        }else{
            error=true;
            return "Incorrect number of arguments for Open :(";
        }
    }
}