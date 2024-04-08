import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicaRepositoryImpl implements IRepository<Cantante> {
    private java.sql.Connection con;
    public MusicaRepositoryImpl(){
        this.con = MusicaService.getConnection();
    }
    public Cantante bdToEntity(ResultSet rs) throws SQLException {
        return new Cantante(rs.getInt("id_artistas"), rs.getNString("nombre"), rs.getInt("edad"),rs.getNString("nacionalidad"), rs.getNString("generoMusical"));
    }

    public void save(Cantante cantante) throws SQLException{
        ResultSet rs;
        PreparedStatement st = null;
        if (cantante.getId() == -1) {
            String query = "INSERT INTO artistas (nombre, edad, nacionalidad, generoMusical) VALUES (?, ?, ?, ?)";

            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, cantante.getNombre());
            st.setInt(2,cantante.getEdad());
            st.setString(3,cantante.getNacionalidad());
            st.setString(4, cantante.getNacionalidad());

            st.executeUpdate();

            //Recuperar el id autogenerado
            rs = st.getGeneratedKeys();
            //Este ResultSet solo puede contener un registro: el ID autogenerado

            if (rs.next()){
                //Ahora ya sabemos cuál es el nuevo id del Usuario
                cantante.setId(rs.getInt(1));
            }

        }

    }

    public void delete(Cantante cantante) throws SQLException{
        PreparedStatement st = con.prepareStatement("DELETE FROM artistas WHERE id = ?");
        st.setInt(1, cantante.getId());
        st.executeUpdate();
        st.close();
    }

    public List<Cantante> findAll() throws SQLException {

        List<Cantante> cantantes = new ArrayList<>();

        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM artistas");

        while(rs.next()){
            //Mapeamos el registro de la BD en un post
            Cantante cantante = bdToEntity(rs);
            //Añadir el Post al conjunto de posts
            cantantes.add(cantante);

        }
        return cantantes;
    }

    public Cantante findById(int id) throws SQLException {
        Cantante cantante = null;
        PreparedStatement st = con.prepareStatement("SELECT nombre, edad, nacionalidad, generoMusical FROM artistas WHERE id = ?");
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            cantante = bdToEntity(rs);
        }
        return cantante;
    }
}
