import java.sql.SQLException;
import java.util.Scanner;

public class musica {
    private static final MusicaRepositoryImpl musicRepository = new MusicaRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        while (true) {
            int option;
            printMenu();
            option = selectOption();
            if (option == 0) {
                break;
            } else {
                switch (option) {
                    case 1: MusicController.printAllSingers(); break;
                    case 2: MusicController.findbyid(); break;
                    case 3: MusicController.addSinger(); break;
                    case 4: MusicController.deleteSinger(); break;

                }
            }

        }

    }
    public static void printMenu() {
        System.out.println("0 Exit | 1 VIEW ALL | 2 FIND BY ID | 3 ADD | 4 DELETE");
    }
    public static int selectOption() {
        Scanner sc = new Scanner(System.in);
        int option;
        while (true) {
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option <= 5) {
                    break;
                } else {
                    System.out.println("Incorrect option");
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Incorrect option");
            }
        }
        return option;
    }
}
