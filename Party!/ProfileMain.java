/**
 * A profile main to test the profile class
 *
 * @author 1909148
 */
public class ProfileMain {
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

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
