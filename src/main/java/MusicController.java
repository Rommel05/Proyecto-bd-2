import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MusicController {
    private static final MusicaRepositoryImpl musicRepository = new MusicaRepositoryImpl();
    public static void prntAllSingers() throws SQLException {
        List<Cantante> cantantes = musicRepository.findAll();
        for (Cantante cantante : cantantes) {
            System.out.println(cantante);
        }
    }

    public static void findbyid() throws SQLException {
        Scanner sc = new Scanner(System.in);
    }
}
