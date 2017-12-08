package Service;


import java.sql.*;

public class DatabaseService {

    private static final String dbUrl = "jdbc:postgresql://localhost:9999/u2017b-4?user=u2017b-4&password=passwordING1";

    private static DatabaseService singleton;

    private Connection conn;
    private Statement st;

    private DatabaseService(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(dbUrl);
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseService getInstance() {
        if(singleton == null) {
            singleton = new DatabaseService();
        }
        return singleton;
    }

    public boolean initializeDB() {
        try {
            st.clearWarnings();
            st.execute(docTypeTable);
            st.execute(countryTable);
            st.execute(provinceTable);
            st.execute(cityTable);
            st.execute(userTable);
            st.execute(productTable);
            st.execute(reviewTable);
            st.execute(pictureTable);
            st.execute(cardTable);
            st.execute(cartTable);
            st.execute(cartProductsTable);
            SQLWarning warning = st.getWarnings();
            return warning == null || warning.getSQLState().equals("42P07");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Statement getSt() {
        return st;
    }

    public String test() {

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test");
            while (rs.next())
            {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "wasa";
    }

    public boolean testInert() {
        try {
            ResultSet rs = st.executeQuery("INSERT INTO test (text) VALUES ('fefe'), ('pepe') RETURNING id");
            while (rs.next())
            {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static final String userTable = "CREATE TABLE IF NOT EXISTS Client (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  username VARCHAR(255) UNIQUE NOT NULL,\n" +
            "  password VARCHAR(255) NOT NULL,\n" +
            "  name VARCHAR(255) NOT NULL,\n" +
            "  surname VARCHAR(255) NOT NULL,\n" +
            "  email VARCHAR(255) NOT NULL,\n" +
            "  idDocType INT NOT NULL REFERENCES DocType(id),\n" +
            "  doc VARCHAR(255) NOT NULL,\n" +
            "  idCountry INT NOT NULL REFERENCES Country(id),\n" +
            "  idProvince INT NOT NULL REFERENCES Province(id),\n" +
            "  idCity INT NOT NULL REFERENCES City(id),\n" +
            "  street VARCHAR(255) NOT NULL,\n" +
            "  streetNum INT NOT NULL,\n" +
            "  apartment VARCHAR(255) NOT NULL,\n" +
            "  postCode VARCHAR(255) NOT NULL,\n" +
            "  phone INT NOT NULL,\n" +
            "  enabled BOOL NOT NULL,\n" +
            "  confirmed BOOL NOT NULL,\n" +
            "  admin BOOL NOT NULL,\n" +
            "  UNIQUE (idDocType, doc)\n" +
            ");";

    private static final String docTypeTable = "CREATE TABLE IF NOT EXISTS DocType (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  name VARCHAR(255) UNIQUE NOT NULL\n" +
            ");";

    private static final String countryTable = "CREATE TABLE IF NOT EXISTS Country (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  name VARCHAR(255) UNIQUE NOT NULL\n" +
            ");";

    private static final String provinceTable = "CREATE TABLE IF NOT EXISTS Province (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  name VARCHAR(255) NOT NULL,\n" +
            "  idCountry INT NOT NULL REFERENCES Country(id),\n" +
            "  UNIQUE (name, idCountry)\n" +
            ");";

    private static final String cityTable = "CREATE TABLE IF NOT EXISTS City (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  name VARCHAR(255) NOT NULL,\n" +
            "  idProvince INT NOT NULL REFERENCES Province(id),\n" +
            "  UNIQUE (name, idProvince)\n" +
            ");";

    private static final String productTable = "CREATE TABLE IF NOT EXISTS Product (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  name VARCHAR(255) NOT NULL,\n" +
            "  description VARCHAR(255) NOT NULL,\n" +
            "  price DOUBLE PRECISION NOT NULL,\n" +
            "  stock INT NOT NULL,\n" +
            "  idClient INT NOT NULL REFERENCES Client(id),\n" +
            "  thumbnail VARCHAR(255) NOT NULL DEFAULT '',\n" +
            "  visits INT NOT NULL DEFAULT 0,\n" +
            "  sold INT NOT NULL DEFAULT 0\n" +
            ");";

    private static final String reviewTable = "CREATE TABLE IF NOT EXISTS Review (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  idProduct INT NOT NULL REFERENCES Product(id),\n" +
            "  comment VARCHAR(2048) NOT NULL,\n" +
            "  rating INT NOT NULL\n" +
            ");";

    private static final String pictureTable = "CREATE TABLE IF NOT EXISTS Picture (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  idProduct INT NOT NULL REFERENCES Product(id),\n" +
            "  path VARCHAR(255) NOT NULL\n" +
            ");";

    private static final String cardTable = "CREATE TABLE IF NOT EXISTS Card (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  idClient INT NOT NULL REFERENCES Client(id),\n" +
            "  name VARCHAR(255) NOT NULL,\n" +
            "  surname VARCHAR(255) NOT NULL,\n" +
            "  number BIGINT NOT NULL,\n" +
            "  day INT NOT NULL,\n" +
            "  month INT NOT NULL,\n" +
            "  code INT NOT NULL,\n" +
            "  UNIQUE (idClient, number)\n" +
            ");";

    private static final String cartTable = "CREATE TABLE IF NOT EXISTS Cart (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  idClient INT NOT NULL REFERENCES Client(id),\n" +
            "  closed BOOL NOT NULL DEFAULT FALSE,\n" +
            "  subtotal DOUBLE PRECISION NOT NULL DEFAULT 0,\n" +
            "  idCard INT REFERENCES Card(id)\n" +
            ");";

    private static final String cartProductsTable = "CREATE TABLE IF NOT EXISTS CartProducts (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  idCart INT NOT NULL REFERENCES Cart(id),\n" +
            "  idProduct INT NOT NULL REFERENCES Product(id),\n" +
            "  amount INT NOT NULL,\n" +
            "  UNIQUE (idCart, idProduct)\n" +
            ");";

}
