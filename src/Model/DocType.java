package Model;

import javax.print.Doc;
import java.util.ArrayList;

public class DocType {
    private int id;
    private String name;

    public DocType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static DocType get(int id) {
        return new DocType(0, "dni");
    }

    public static ArrayList<DocType> list() {
        return new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
