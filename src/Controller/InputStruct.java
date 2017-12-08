package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class InputStruct {
    protected Map<Integer,FormEntry> formEntries;
    public InputStruct(){
        formEntries= new HashMap<Integer,FormEntry>();
    }

    public Map<Integer,FormEntry> getFormEntries() {
        return formEntries;
    }
    @Override
    public String toString(){
        String ret = new String();

        for(Integer i: formEntries.keySet()){
            ret+=(formEntries.get(i).getCode()+": "+formEntries.get(i).getString()+" ");
        }
        return ret;
    }
}
