import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MusicController {
    private static final MusicaRepositoryImpl musicRepository = new MusicaRepositoryImpl();
    public static void printAllSingers() throws SQLException {
        List<Cantante> cantantes = musicRepository.findAll();
        for (Cantante cantante : cantantes) {
            System.out.println(cantante);
        }
    }

    public static void findbyid() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("id: ");
        int id_artistas = Integer.parseInt(sc.nextLine());
        Cantante c = musicRepository.findById(id_artistas);
        System.out.println(c);
    }

    public static void addSinger() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        String name = sc.nextLine();
        System.out.println("Introduce la edad:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce la nacionalidad:");
        String nationality = sc.nextLine();
        System.out.println("Introduce el género musical:");
        String musicalGenre = sc.nextLine();
        Cantante c = new Cantante (name,age,nationality,musicalGenre);
        musicRepository.save(c);
    }

    public static void deleteSinger() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        String name = sc.nextLine();
        Cantante c = musicRepository.findByName(name);
        musicRepository.delete(c);
    }
}
