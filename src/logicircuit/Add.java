
import logicircuit.LCComponent;

public class Add{
    private String varName;
    private LCComponent secondArg;
    private int x;
    private int y;
    private String notes;
    
    public Add(){

    }
    public void setVarName(String str){
        this.varName=str;
    }
    public void setSecondArg(LCComponent l){
        this.secondArg=l;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setNotes(String str){
        this.notes=str;
    }
    public String getVarName(){return varName;}
    public Object getSecondArg(){return secondArg;}
    public int getX(){return x;}
    public int getY(){return y;}
    public String getNotes(){return notes;}
    public Add StringToLiteral(String str,String[]messages){
        Add result=new Add();
        int point=str.indexOf(":");
        boolean syntaxErrorDots=(point==-1);
        boolean syntaxErrorArroba=false;
        boolean var_warning=false;
        boolean tipoPorta_warning=false;
        boolean syntaxErrorVirgula=false;
        boolean syntaxErrorNumberX=false;
        boolean syntaxErrorNumberY=false;
        boolean syntaxErrorBrackets=false;
        boolean logicalError=false;
        messages[0]+=(syntaxErrorDots)?"After ADD instruction there's supposed to be ':'\n":"";
        if(!syntaxErrorDots){
            String lower=str.substring(0,point),upper=str.substring(point+1);
            lower=lower.replace("ADD","");lower=lower.trim();var_warning=lower.contains(" ");lower=lower.replace(" ","");
            String varNamee=lower;point=upper.indexOf("@");
            syntaxErrorArroba=(point==-1);
            messages[0]+=(var_warning)?"Variable cannot contain spaces, corrected it by deleting all of its spaces\n":"";
            messages[0]+=(syntaxErrorArroba)?"In ADD instruction after ':' there's supposed to be a '@' \n":"";
            if(!syntaxErrorArroba){
                String tipo_porta=upper.substring(0,point),coordinatesAndNotes=upper.substring(point+1);
                tipo_porta=tipo_porta.trim();tipoPorta_warning=tipo_porta.contains(" ");tipo_porta=tipo_porta.replace(" ","");
                point=coordinatesAndNotes.indexOf(",");
                syntaxErrorVirgula=(point==-1);
                messages[0]+=(tipoPorta_warning)?"Gate type cannot contain spaces, corrected it by deleting all of its spaces\n":"";
                messages[0]+=(syntaxErrorVirgula)?"There's supposed to be ',' separating coordinates\n":"";
                if(!syntaxErrorVirgula){
                    String coordX=coordinatesAndNotes.substring(0,point);
                    String coordYAndNotes=substring(point+1);
                    coordX=coordX.replace(" ","");
                    int X=0;syntaxErrorNumberX=false;
                    try{
                        X=Integer.parseInt(coordX);
                    }catch(NumberFormatException e){
                        syntaxErrorNumberX=true;
                    }
                    messages[0]+=(syntaxErrorNumberX)?"X coordinate is an integer, \""+coordX+"\" invalid\n":"";
                    if(!syntaxErrorNumberX){
                        int p1=coordYAndNotes.indexOf("["),p2=coordYAndNotes.indexOf("]");
                        boolean p=(p1!=-1),q=(p2!=-1);
                        syntaxErrorBrackets=!((!p||q)&&(!q||p));
                        messages[0]+=(syntaxErrorBrackets)?"Either there's [] or their complete absence\n":"";
                        if(!syntaxErrorBrackets){
                            String coordY,notess;
                            coordY=(coordYAndNotes.contains("["))?coordYAndNotes.substring(0,p1):coordYAndNotes.trim().replace(" ","");
                            notess=(coordYAndNotes.contains("["))?coordYAndNotes.substring(p1+1).trim():coordYAndNotes.trim();
                            int Y=0;
                            try{
                                Y=Integer.parseInt(coordY);
                            }catch(NumberFormatException e){
                                syntaxErrorNumberY=true;
                            }
                            message[0]+=(syntaxErrorNumberY)?"Y coordinate is an integer, \""+coordY+"\" invalid\n":"";
                            if(!syntaxErrorNumberY){
                                result.setNotes(notess);
                                result.setVarName(varNamee);
                                result.setX(X);
                                result.setY(Y);
                                if(tipo_porta.toUpperCase().equals("SWITCH")){
                                    result.setSecondArg(LCComponent.SWITCH);
                                }else if(tipo_porta.toUpperCase().equals("AND")){
                                    result.setSecondArg(LCComponent.AND);
                                }else if(tipo_porta.toUpperCase().equals("OR")){
                                    result.setSecondArg(LCComponent.OR);
                                }else if(tipo_porta.toUpperCase().equals("NOT")){
                                    result.setSecondArg(LCComponent.NOT);
                                }else if(tipo_porta.toUpperCase().equals("XOR")){
                                    result.setSecondArg(LCComponent.XOR);
                                }else if(tipo_porta.toUpperCase().equals("NOR")){
                                    result.setSecondArg(LCComponent.NOR);
                                }else if(tipo_porta.toUpperCase().equals("LED")){
                                    result.setSecondArg(LCComponent.LED);
                                }else if(tipo_porta.toUpperCase().equals("DISPLAY")){
                                    result.setSecondArg(LCComponent.BIT3_DISPLAY);
                                }else if(tipo_porta.toUpperCase().equals("NAND")){
                                    result.setSecondArg(LCComponent.NAND);
                                }else{
                                    logicalError=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(!syntaxErrorDots && !syntaxErrorArroba && !syntaxErrorVirgula && !syntaxErrorNumberX && !syntaxErrorNumberY && !logicalError){
            return result;
        }else{
            return new Add();
        }
    }
}