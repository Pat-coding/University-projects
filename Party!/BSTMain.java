/**
 * The testing for the Binary search tree.
 *
 * @author 1909148
 */
public class BSTMain {
    public static void main(String[] args) {
        String[] randomInterests;
        randomInterests = new String[]{"Kiting", "knitting", "Being bored all the time"};
        String[] randomGroups;
        randomGroups = new String[]{"Playing video Games", "Yoga"};
        Profile test1 = new Profile("Laura", "Sarah", 11, 12, 1998,
                "a@abc", randomInterests, randomGroups);
        Profile test2 = new Profile("Clara", "Abi", 21, 6, 2000,
                "abc@hotmail.com", randomInterests, randomGroups);
        Profile test3 = new Profile("Ara", "Laime", 6, 8, 1997,
                "c@hotmail.com", randomInterests, randomGroups);

        BST tests;
        tests = new BST();
        tests.insertProfile(test1);
        tests.insertProfile(test2);
        tests.insertProfile(test3);

        System.out.println(tests.toString());
    }
}
