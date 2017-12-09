package Controller;


import Model.Area;

/**
 * Created by Usuario on 09/12/2017.
 */
public class AreaEntry extends MyEntry{
    private Area area;
    private int code;
    public AreaEntry(Area area, int code){
        this.area=area;
        this.code=code;
    }
    public Area getItem(){
        return area;
    }
    public int getCode(){
        return code;
    }
}
