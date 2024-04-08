import java.sql.SQLException;
import java.util.List;

public class musica {
    private static final MusicaRepositoryImpl musicRepository = new MusicaRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        List<Cantante> cantantes = musicRepository.findAll();
        cantantes.forEach(System.out::println);
    }
}
