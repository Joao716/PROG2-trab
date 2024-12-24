package commands_union;
import commands.Cmd;
import cmd_to_object.*;

public class Command {
    private static final short ADD=0;
    private static final short OPEN=1;
    private static final short SAVE=4;
    private static final short TURN=2;
    private static final short WIRE=3;
    private static final short ERROR=-1;
    private boolean error;
    private String errorMessage;
    private Add add;
    private Open open;
    private Save save;
    private Turn turn;
    private Wire wire;
    private Cmd cmd;

    public Command() {
        add=new Add();
        open=new Open();
        save=new Save();
        turn=new Turn();
        wire=new Wire();
        cmd=new Cmd();
        error=false;
    }
    public void getProcessedCommand(String cmd){
        String res=this.cmd.processAny(cmd);
        error=this.cmd.isError();
        if(error){
            errorMessage=res;
            return;
        }
        Object aux;
        switch(this.cmd.getCode()){
            case ADD:
                aux=add.StringToLiteral(res);
                if(!(aux instanceof String)){
                    add=(Add)aux;
                }else{
                    errorMessage=(String)aux;
                    error=true;
                }
                break;
            case OPEN:
                aux=open.StringToLiteral(res);
                if(!(aux instanceof String)){
                    open=(Open)aux;
                }else{
                    errorMessage=(String)aux;
                    error=true;
                }
                break;
            case SAVE:
                aux=save.StringToLiteral(res);
                if(!(aux instanceof String)){
                    save=(Save)aux;
                }else{
                    errorMessage=(String)aux;
                    error=true;
                }
                break;
            case TURN:
                aux=turn.StringToLiteral(res);
                if(!(aux instanceof String)){
                    turn=(Turn)aux;
                }else{
                    errorMessage=(String)aux;
                    error=true;
                }
                break;
            case WIRE:
                aux=wire.StringToLiteral(res);
                if(!(aux instanceof String)){
                    wire=(Wire)aux;
                }else{
                    errorMessage=(String)aux;
                    error=true;
                }
                break;
            default:
                break;
        }
    }
    public String getError(){return errorMessage;}
    public boolean isError(){return error;}
    public Add getAdd() {
        return add;
    }

    public Open getOpen() {
        return open;
    }

    public Save getSave() {
        return save;
    }

    public Turn getTurn() {
        return turn;
    }

    public Wire getWire() {
        return wire;
    }

    public Cmd getCmd() {
        return cmd;
    }
}
