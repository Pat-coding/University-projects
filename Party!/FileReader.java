import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The file reader class to data files containing the profiles.
 *
 * @author 1909148
 */
public class FileReader {

    /**
     * A method to read the data files.
     *
     * @param filename The file name in String.
     * @return The Scanner data to the readProfile method.
     */
    public static BST readProfileSet(String filename) {
        //Insert the location of the file before the filename here
        File file = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return readProfile(in);
    }

    /**
     * A method to read the profile and add it to the Binary search tree class for construction
     *
     * @param in The file data.
     * @return The profiles as a Binary search tree.
     */
    private static BST readProfile(Scanner in) {
        BST profile = new BST();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner newLine = new Scanner(line);
            newLine.useDelimiter(",");
            String lastName = newLine.next();
            String firstName = newLine.next();
            int day = newLine.nextInt();
            int month = newLine.nextInt();
            int year = newLine.nextInt();
            String email = newLine.next();
            String[] interest = readProfileInterest(newLine);
            String[] groups = readProfileGroup(newLine);
            Profile tempProfile = new Profile(firstName, lastName, day, month, year, email, interest, groups);
            System.out.println("Node created! :");
            System.out.println(tempProfile.toString());
            profile.insertProfile(tempProfile);
        }
        System.out.println(profile.toString());
        return profile;
    }

    /**
     * A method to read the interests of the profiles.
     *
     * @param newLine The line scanner.
     * @return The interests in an array of String.
     */
    private static String[] readProfileInterest(Scanner newLine) {
        String[] interest;
        String temp = newLine.next();
        interest = temp.split(";");
        return interest;
    }

    /**
     * A method to read the groups of the profiles.
     *
     * @param newLine The line scanner.
     * @return The groups in an array of String.
     */
    private static String[] readProfileGroup(Scanner newLine) {
        String[] activity;
        String temp = newLine.next();
        activity = temp.split(";");
        return activity;
    }
}
