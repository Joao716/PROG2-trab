package logicircuit;
public class P_turn implements CmdProcessor{
    public P_turn(){

    }
    @Override
    public String process(String text){
        String[]parts=text.split(" ");
        boolean notEnoughArgs=(parts.length!=3);
        if(!notEnoughArgs){
            return parts[1].trim()+"\n"+parts[2].trim();
        }else{
            return "Incorrect number of arguments for Turn :(";
        }
    }
}