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
}
