package commands;

public class Cmd{
    private final String ADD="ADD";
    private final String OPEN="OPEN";
    private final String TURN="TURN";
    private final String WIRE="WIRE";
    private final String SAVE="SAVE";
    private short code;
    private boolean error;
    private P_add add;
    private P_wire wire;
    private P_close close;
    private P_open open;
    private P_turn turn;
    private P_save save;
    public Cmd(){
        error=false;
        add=new P_add();
        wire=new P_wire();
        close=new P_close();
        open=new P_open();
        turn=new P_turn();
        save=new P_save();
        code=-1;
    }
    public boolean isError(){return error;}
    public short getCode(){return code;}
    public String processAny(String cmd){
        String command="";
        command=(cmd.toUpperCase().contains(ADD))?ADD:(cmd.toUpperCase().contains(OPEN))?OPEN:(cmd.toUpperCase().contains(TURN))?TURN:(cmd.toUpperCase().contains(WIRE))?WIRE:(cmd.toUpperCase().contains(SAVE))?SAVE:command;
        boolean err=false;
        String res=new String();
        switch(command){
            case ADD:
                code=0;
                res+=add.process(cmd);
                break;
            case OPEN:
                code=1;
                res+=open.process(cmd);
                break;
            case TURN:
                code=2;
                res+=turn.process(cmd);
                break;
            case WIRE:
                code=3;
                res+=wire.process(cmd);
                break;
            case SAVE:
                code=4;
                res+=save.process(cmd);
                break;
            default:
                code=-1;
                err=true;
                res+="No Command found";
                break;
        }
        error=err||add.isError()||save.isError()||open.isError()||turn.isError()||wire.isError();
        return res;
    }
}