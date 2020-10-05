/**
 * The main class for testing the BSTNode.
 *
 * @author 1909148
 */

public class BSTNodeMain {

    public static void doSomething(int a, int b) {
        b = a;
    }
    public static void main(String[] args) {
        String[] randomInterest;
        randomInterest = new String[]{"Fighting Bad guys!", "Cooking"};
        String[] bye = new String[0];
        Profile a = new Profile("Shirou", "Emiya", 24, 12, 1984, "c@email",
                randomInterest, bye);
        Profile b = new Profile("Cake", "Bake", 12, 1, 3000, "aa",
                randomInterest, bye);
        Profile c = new Profile("c", "p", 1, 2, 3, "a",
                randomInterest, bye);

        BSTNode test1 = new BSTNode(a);
        BSTNode test2 = new BSTNode(b);
        BSTNode test3 = new BSTNode(c);

        doSomething(5, 5);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());
    }
}
