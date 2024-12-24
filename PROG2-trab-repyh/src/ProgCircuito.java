import LogicCircuit.*;
import Circuits.*;
import commands_union.*;
public class ProgCircuito {
    public static void main(String[] args) {
        ProgCircuito progCircuito = new ProgCircuito();
        progCircuito.start();
    }

    public int start(){
        String[]addTest={"AdD ert:and@-1,-2[lkjlklkjlkj]","AdD ert:Or@-1,-2[lkjlklkjlkj klooooOOOOOOO]",
        "AdD ert : switch@-1,-2[lkjlklkjlkj]","Add ert : switch @ -1,-2 [lkjlklkjlkj]"};
        Command c=new Command();
        for(int i=0;i<addTest.length;i++){
            c.getProcessedCommand(addTest[i]);
            if(!c.isError()){
                ObjectPrinter.printObject(c.getAdd());
            }else{
                System.out.println(c.getError());
            }
            System.out.println("\n\n");
        }

        return 0;
    }
}
