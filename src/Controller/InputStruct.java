package Controller;

import java.util.ArrayList;

public abstract class InputStruct {
    private ArrayList<FormEntry> formEntries;
    public InputStruct(){
        formEntries= new ArrayList<>();
    }

    public ArrayList<FormEntry> getFormEntries() {
        return formEntries;
    }
}
