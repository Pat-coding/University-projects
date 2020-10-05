/**
 * The Binary search tree class where the tree itself is constructed, starting with the root.
 *
 * @author 1909148
 */
public class BST {
    private BSTNode root;

    public BST() {

    }

    /**
     * A method to recursively traverse through the Binary search tree and print the nodes in inorder (which is
     * alphabetical).
     *
     * @param root The root of the tree.
     */
    private static void printAlphabetical(BSTNode root) {
        //Base case
        if (root == null) {
            return;
        }

        //recursion for left side of the tree
        printAlphabetical(root.getL());
        System.out.println(root.getProfile().getLastName() + " " + root.getProfile().getFirstName());
        //recursion for the right side of the tree
        printAlphabetical(root.getR());
    }

    /**
     * A method to start printing the Binary search tree.
     */
    public void startPrint() {
        printAlphabetical(root);
    }

    /**
     * A method to start constructing the Binary search tree.
     *
     * @param p The profile for the node.
     */
    public void insertProfile(Profile p) {
        if (root == null) {
            this.root = new BSTNode(p);
        } else {
            placeNode(p, root);
        }
    }

    /**
     * A method to compare the last name of two profiles.
     *
     * @param p    The profile for the node.
     * @param root The current node.
     */
    private void placeNode(Profile p, BSTNode root) {
        String name = root.getProfile().getLastName();
        String curName = p.getLastName();
        int compare = curName.compareTo(name);
        compareAlphabets(compare, p, root);
    }

    /**
     * A method to recursively add profiles to left or right nodes alphabetically.
     *
     * @param compare The integer value when compared alphabetically with current node.
     * @param p       The profile for the node.
     * @param root    THe current node.
     */
    private void compareAlphabets(int compare, Profile p, BSTNode root) {

        if (compare < 0) {
            //base case 1
            if (root.getL() == null) {
                root.setL(new BSTNode(p));
                //recursion
            } else {
                placeNode(p, root.getL());
            }
            //after
        } else if (compare > 0) {
            //base case 2
            if (root.getR() == null) {
                root.setR(new BSTNode(p));
                //recursion
            } else {
                placeNode(p, root.getR());
            }
        } else {
            compareFirstName(p, root);
        }
    }

    /**
     * A method in the case where the last name is the same and a way to deal with duplicate names.
     *
     * @param p    The profile for the node.
     * @param root The current node.
     */
    private void compareFirstName(Profile p, BSTNode root) {
        String name = root.getProfile().getFirstName();
        String curName = p.getFirstName();

        int compare = curName.compareTo(name);

        //dealing with duplicates to prevent stackoverflow error
        if (compare == 0) {
            if (root.getL() == null) {
                root.setL(new BSTNode(p));
            } else {
                root.setR(new BSTNode(p));
            }
        } else {
            compareAlphabets(compare, p, root);
        }
    }

    /**
     * A toString method for testing purposes.
     *
     * @return The result in string.
     */
    @Override
    public String toString() {
        String result = "";
        //Note that this String is tailored for the tree in the BSTMain class
        result = root.toString() + "\n" + root.getL().toString() + "\n" + root.getL().getR().toString();
        return result;
    }
}
