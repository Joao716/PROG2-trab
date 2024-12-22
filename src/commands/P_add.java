package commands;
import logicircuit.*;
public class P_add implements CmdProcessor{
    private boolean error;
    public P_add(){
        error=false;
    }
    public boolean isError(){return error;}
    @Override 
    public String process(String text){
        String result=new String();
        int index=text.indexOf('@');
        boolean errorNoAtSign=(index==-1);
        boolean errorNoChunkAfterAtSign=false;
        String chunkBeforeAtSign=new String(),chunkAfterAtSign=new String();
        if(!errorNoAtSign){
            chunkBeforeAtSign=text.substring(0,index);
            try{
                chunkAfterAtSign=text.substring(index+1);
            }catch(Exception e){
                errorNoChunkAfterAtSign=true;
            }
        }
        index=chunkAfterAtSign.indexOf(',');
        boolean errorNoCommaFound=(index==-1);
        boolean errorNothingAfterComma=false;
        boolean errorBrackets=false;
        String coordX=new String(),CoordYAndName=new String(),name=new String(),coordY=new String();
        if(!errorNoCommaFound){
            coordX=chunkAfterAtSign.substring(0,index);
            coordX=coordX.replaceAll(" ","");
            try{
                CoordYAndName=chunkAfterAtSign.substring(index+1);
            }catch(Exception e){
                errorNothingAfterComma=true;
            }
            int openBracket=CoordYAndName.indexOf('['),closingBracket=CoordYAndName.indexOf(']');
            boolean p=(openBracket==-1),q=(closingBracket==-1);
            errorBrackets=!((!p||q)&&(!q||p));
            if(!errorBrackets){
                name=CoordYAndName.substring(openBracket,closingBracket);
                coordY=CoordYAndName.substring(0,openBracket);
            }else{
                coordY=CoordYAndName;
            }
        }
        index=chunkBeforeAtSign.indexOf(':');
        boolean errorNoColonFound=(index==-1);
        String id=new String(),gateType=new String();
        if(!errorNoColonFound){
            id=chunkBeforeAtSign.substring(0,index);
            id=id.toLowerCase();
            id=id.replaceAll(" ","");
            id=id.replaceAll("add","");
            gateType=chunkBeforeAtSign.substring(index+1); 
        }
        if(!errorBrackets && !errorNoAtSign && !errorNoChunkAfterAtSign && !errorNoColonFound && !errorNoCommaFound && !errorNothingAfterComma){
            return id.trim()+"\n"+gateType.trim()+"\n"+coordX.trim()+"\n"+coordY.trim()+"\n"+name.trim();
        }else{
            error=true;
            result=(errorBrackets)?result+"Either you have 2 brackets or you've none\n":result;
            result=(errorNoAtSign)?result+"No @ symbol found :(\n":result;
            result=(errorNoChunkAfterAtSign)?"Chunk after @ is empty :(\n":result;
            result=(errorNoColonFound)?"There's supposed to be a : separating the id and the gate type\n":result;
            result=(errorNoCommaFound)?"There's supposed to be a , separating coordinates\n":result;
            result=(errorNothingAfterComma)?"found nothing after comma :(\n":result;
            return result;
        }
    }
}