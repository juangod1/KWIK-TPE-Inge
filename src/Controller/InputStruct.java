package Controller;

import java.util.ArrayList;

public abstract class InputStruct {
    protected ArrayList<FormEntry> formEntries;
    public InputStruct(){
        formEntries= new ArrayList<>();
    }

    public ArrayList<FormEntry> getFormEntries() {
        return formEntries;
    }
    @Override
    public String toString(){
        String ret = new String();
        for(FormEntry fe: formEntries){
            ret+=(fe.getCode()+": "+fe.getString()+" ");
        }
        return ret;
    }
}
