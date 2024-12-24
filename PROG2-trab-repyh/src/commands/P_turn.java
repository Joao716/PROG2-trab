package commands;

import LogicCircuit.CmdProcessor;

public class P_turn implements CmdProcessor{
    private boolean error;
    public P_turn(){
        error=false;
    }
    public boolean isError(){
        return error;
    }
    @Override
    public String process(String text){
        String[]parts=text.split(" ");
        boolean notEnoughArgs=(parts.length!=3);
        if(!notEnoughArgs){
            return parts[1].trim()+"\n"+parts[2].trim();
        }else{
            error=true;
            return "Incorrect number of arguments for Turn :(";
        }
    }
}