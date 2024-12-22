package Commands;

import LogicCircuit.CmdProcessor;

public class P_wire implements CmdProcessor{
    private boolean error;
    public P_wire(){
        error=false;
    }
    public boolean isError(){
        return error;
    }
    @Override
    public String process(String text){
        String[]parts=text.split(" ");
        boolean notEnoughArgs=(parts.length!=4);
        if(!notEnoughArgs){
            return parts[1].trim()+"\n"+parts[2].trim()+"\n"+parts[3].trim();
        }else{
            error=true;
            return "Incorrect number of arguments for Wire :(";
        }
    }
}