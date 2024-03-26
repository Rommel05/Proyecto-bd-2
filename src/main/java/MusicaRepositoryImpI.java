import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MusicaRepositoryImpI {
    private static Set<Cantante> cantanteCached = new HashSet<>();
    private java.sql.Connection con;
    public MusicaRepositoryImpI() throws SQLException{
        this.con = MusicaService.getConnection();
    }
}
