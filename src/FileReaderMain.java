import java.util.Scanner;

/**
 * The File reader main class to test the file reading.
 *
 * @author 1909148
 */
public class FileReaderMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter filename");
        String filename = in.nextLine();
        FileReader.readProfileSet(filename);
    }
}
