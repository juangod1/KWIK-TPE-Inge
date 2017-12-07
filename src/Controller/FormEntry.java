package Controller;

public class FormEntry {
    private String string;
    private int code;
    public FormEntry(String string, int code){
        this.string=string;
        this.code=code;
    }
    public String getString(){
        return string;
    }
    public int getCode(){
        return code;
    }
}
