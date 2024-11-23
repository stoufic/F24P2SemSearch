/**
 * The Class EmptyNode.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class EmptyNode implements BinNode {

    /** The instance. */
    private static EmptyNode instance = null;

    /**
     * Instantiates a new empty node.
     */
    private EmptyNode() {
    }


    /**
     * Gets the single instance of EmptyNode.
     *
     * @return single instance of EmptyNode
     */
    public static EmptyNode getInstance() {
        if (instance == null) {
            instance = new EmptyNode();
        }
        return instance;
    }


    /**
     * Checks if is leaf.
     *
     * @return true, if is leaf
     */
    @Override
    public boolean isLeaf() {
        return false;
    }


    /**
     * Gets the seminar.
     *
     * @return the seminar
     */
    @Override
    public Seminar getSeminar() {
        return null;
    }


    /**
     * Gets the left.
     *
     * @return the left
     */
    @Override
    public BinNode getLeft() {
        return null;
    }


    /**
     * Gets the right.
     *
     * @return the right
     */
    @Override
    public BinNode getRight() {
        return null;
    }


    /**
     * Sets the left.
     *
     * @param left
     *            the new left
     */
    @Override
    public void setLeft(BinNode left) {
        // Do nothing
    }


    /**
     * Sets the right.
     *
     * @param right
     *            the new right
     */
    @Override
    public void setRight(BinNode right) {
        // Do nothing
    }


    /**
     * Checks if is split on X.
     *
     * @return true, if is split on X
     */
    @Override
    public boolean isSplitOnX() {
        return false;
    }


    /**
     * Prints the.
     *
     * @param depth
     *            the depth
     */
    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.println("(E)");
    }


    /**
     * Prints the.
     *
     * @param node
     *            the node
     * @param depth
     *            the depth
     */
    @Override
    public void print(BinNode node, int depth) {
        print(depth);
    }


    /**
     * Increment depth.
     *
     * @param depth
     *            the depth
     * @return the int
     */
    @Override
    public int incrementDepth(int depth) {
        return depth - 1;
    }


    /**
     * Delete.
     *
     * @param id
     *            the id
     * @param targetX
     *            the target X
     * @param targetY
     *            the target Y
     * @param xMin
     *            the x min
     * @param yMin
     *            the y min
     * @param xMax
     *            the x max
     * @param yMax
     *            the y max
     * @param depth
     *            the depth
     * @return the bin node
     */
    @Override
    public BinNode delete(
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth) {
        return instance;
    }


    /**
     * Prints the indent.
     *
     * @param depth
     *            the depth
     */
    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }
}
