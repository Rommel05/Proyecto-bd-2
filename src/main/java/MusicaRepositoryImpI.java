import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommentRepositoryImpl implements IRepository<Cantante> {
    private static Set<Cantante> cantantesCached = new HashSet<>();
    private java.sql.Connection con;

    public CommentRepositoryImpl() throws SQLException {
        this.con = MusicaService.getConnection();
    }

    public List<Cantante> findAll() throws SQLException {

        List<Cantante> cantantes = new ArrayList<>();

        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM comments ORDER BY date DESC");

        while(rs.next()){
            //Mapeamos el registro de la BD en un post
            Cantante cantante = bdToEntity(rs);
            //Añadir el Post al conjunto de posts
            cantantes.add(cantante);

        }
        return cantantes;
    }

}
