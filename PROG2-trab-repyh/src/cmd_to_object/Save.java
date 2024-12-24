package cmd_to_object;

public class Save implements ToLiteral {
    private String file;

    public Save() {
    }

    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    @Override
    public Object StringToLiteral(String input){
        Save s=new Save();
        s.setFile(input.trim());
        return s;
    }
}
