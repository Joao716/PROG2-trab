package Commands;

public class Cmd{
    private static final String ADD = "ADD";
    private static final String CLOSE = "CLOSE";
    private static final String OPEN = "OPEN";
    private static final String TURN = "TURN";
    private static final String WIRE = "WIRE";

    private boolean error;
    private P_add add;
    private P_wire wire;
    private P_close close;
    private P_open open;
    private P_turn turn;

    public Cmd(){
        error = false;
        add = new P_add();
        wire = new P_wire();
        close = new P_close();
        open = new P_open();
    }

    public boolean isError(){return error;}

    public String processAny(String cmd){
        String command=(cmd.toUpperCase().contains(ADD))?ADD:(cmd.toUpperCase().contains(CLOSE))?CLOSE:(cmd.toUpperCase().contains(OPEN))?OPEN:(cmd.toUpperCase().contains(TURN))?TURN:(cmd.toUpperCase().contains(WIRE))?WIRE:null;
        boolean err=false;
        String res=new String();

        switch(command){
            case ADD:
                res+=add.process(cmd);
                break;
            case CLOSE:
                res+=close.process(cmd);
                break;
            case OPEN:
                res+=open.process(cmd);
                break;
            case TURN:
                res+=turn.process(cmd);
                break;
            case WIRE:
                res+=wire.process(cmd);
                break;
            default:
                err=true;
                res+="No Command found";
                break;
        }

        error=err||add.isError()||close.isError()||open.isError()||turn.isError()||wire.isError();
        return res;
    }
}