package logicircuit;
public enum Instruction{
    Add,Wire,Turn,Save,Open;
    public String toString(){
        switch(this){
            case Add:
                return "ADD";
            case Wire:
                return "WIRE";
            case Turn:
                return "TURN";
            case Save:
                return "SAVE";
            case Open:
                return "OPEN";
            default:
                return "ERROR";
        }
    }
    public String Manual(){
        String result;
        switch(this){
            case Add:
                result="Usage => ADD <id>:<tipo_porta>@<coord_X>,<coord_Y> [<legenda>]";
                break;
            case Wire:
                result="Usage => WIRE <id_elemento1> <id_elemento2> <input_pin_elemento2>";
                break;
            case Turn:
                result="Usage => TURN <state> <id_elemento_entrada>";
                break;
            case Save:
                result="Usage => SAVE <nome_do_ficheiro>";
                break;
            case Open:
                result="Usage => OPEN <nome_do_ficheiro>";
                break;
            default:
                result="MANUAL ERROR";
                break;
        }
        return result;
    }
}