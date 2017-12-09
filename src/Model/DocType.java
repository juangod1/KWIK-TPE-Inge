package Model;

import Service.DatabaseService;

import javax.print.Doc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocType {
    private int id;
    private String name;

    private static final String select = "SELECT * FROM docType ";

    public DocType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static DocType get(int id) {
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select + "WHERE id ="+id);
            if(rs.next())
                return fromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<DocType> list() {
        ArrayList<DocType> docs = new ArrayList<>();
        try {
            ResultSet rs = DatabaseService.getInstance().getSt().executeQuery(select);
            while (rs.next())
                docs.add(fromResultSet(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docs;
    }

    private static DocType fromResultSet(ResultSet rs) {
        try {
            return new DocType(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
