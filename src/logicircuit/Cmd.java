package logicircuit;
public class Cmd{
    private boolean error;
    private P_add add;
    private P_wire wire;
    private P_close close;
    private P_open open;
    public Cmd(){
        error=false;
        add=new P_add();
        wire=new P_wire();
        close=new P_close();
        open=new P_open();
    }
    public boolean isError(){return error;}
    public String processAny(String cmd){

    }
}