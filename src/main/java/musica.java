import java.sql.SQLException;

public class musica {
    private static  java.sql.Connection con;
    public static void main(String[] args) throws SQLException {
        String host = "jdbc:sqlite:src/main/resources/musica";
        con = java.sql.DriverManager.getConnection( host );
    }
}
