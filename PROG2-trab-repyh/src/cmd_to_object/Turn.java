package cmd_to_object;

public class Turn implements ToLiteral {
    private static final String on="ON";
    private static final String off="OFF";
    private boolean error;
    private boolean onOff;
    private String id;

    public Turn() {
        error=false;
    }
    public boolean isError(){return error;}
    public boolean isOn() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    // Getter and setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private boolean SpecialStringCompare(String str,String cmp){
        return str.toUpperCase().trim().equals(cmp);
    }
    @Override 
    public Object StringToLiteral(String input){
        Object res=new Object();
        String errorMessage="";
        String[]parts=input.split("\n");
        Turn t=new Turn();
        if(SpecialStringCompare(parts[0],on)){
            t.setOnOff(true);
        }else if(SpecialStringCompare(parts[0],off)){
            t.setOnOff(false);
        }else{
            errorMessage="state "+parts[0]+" is invalid, it can be either ON or OFF\n";
            error=true;
        }
        t.setId(parts[1]);
        if(errorMessage.equals("")){
            res=t;
        }else{
            res=errorMessage;
        }
        return res;
    }
}
