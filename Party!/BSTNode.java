/**
 * The binary search tree node class. This is where the leaf and children of a tree is sorted.
 *
 * @author 1909148
 */
public class BSTNode {
    private Profile profile;
    private BSTNode l;
    private BSTNode r;

    /**
     * The constructor for BSTNode.
     *
     * @param profile The profile for the nodes.
     */
    public BSTNode(Profile profile) {
        this.profile = profile;
    }

    /**
     * A getter for the profile.
     *
     * @return The profile of the node
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * A getter for left node.
     *
     * @return The left node.
     */
    public BSTNode getL() {
        return l;
    }

    /**
     * A setter for left node.
     *
     * @param l The left node value.
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * A getter for right node.
     *
     * @return The right node.
     */
    public BSTNode getR() {
        return r;
    }

    /**
     * A setter for right node.
     *
     * @param r The right node value.
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     * A toString method for testing purposes.
     *
     * @return The result in String.
     */
    @Override
    public String toString() {
        String result = "";
        return result = profile.toString();
    }
}
