package cmd_to_object;

public class Open implements ToLiteral {
    private String file;

    public Open() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    @Override
    public Object StringToLiteral(String input){
        Open o=new Open();
        o.setFile(input.trim());
        return o;
    }
}
