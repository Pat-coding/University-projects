/**
 * The main method for testing alphabetical printing for BST class.
 *
 * @author 1909148
 */
public class AlphaMain {
    public static void main(String[] args) {

        String[] hi = new String[0];
        Profile a = new Profile("Peter", "Penkin", 1, 2, 3, "a",
                hi, hi);
        //testing for the same last name
        Profile b = new Profile("Arnold", "Penkin", 1, 2, 3, "a",
                hi, hi);
        //testing for duplicate names
        Profile c = new Profile("Peter", "Penkin", 1, 2, 3, "a",
                hi, hi);
        Profile d = new Profile("Laura", "Sarah", 1, 2, 3, "a",
                hi, hi);
        Profile e = new Profile("Clara", "Maime", 1, 2, 3, "a",
                hi, hi);

        BST abc;
        abc = new BST();
        abc.insertProfile(a);
        abc.insertProfile(b);
        abc.insertProfile(c);
        abc.insertProfile(d);
        abc.insertProfile(e);
        abc.startPrint();

        System.out.println(abc.toString());
    }
}
