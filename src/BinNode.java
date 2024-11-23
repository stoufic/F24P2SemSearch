/**
 * The Interface BinNode.
 * 
 * @author toufi
 * @version 10.20.24
 */
public interface BinNode {

    /**
     * Checks if is leaf.
     *
     * @return true, if is leaf
     */
    boolean isLeaf();


    /**
     * Gets the seminar.
     *
     * @return the seminar
     */
    Seminar getSeminar();


    /**
     * Gets the left.
     *
     * @return the left
     */
    BinNode getLeft();


    /**
     * Gets the right.
     *
     * @return the right
     */
    BinNode getRight();


    /**
     * Sets the left.
     *
     * @param left
     *            the new left
     */
    void setLeft(BinNode left);


    /**
     * Sets the right.
     *
     * @param right
     *            the new right
     */
    void setRight(BinNode right);


    /**
     * Checks if is split on X.
     *
     * @return true, if is split on X
     */
    boolean isSplitOnX();


    /**
     * Prints the.
     *
     * @param depth
     *            the depth
     */
    void print(int depth);


    /**
     * Prints the.
     *
     * @param node
     *            the node
     * @param depth
     *            the depth
     */
    void print(BinNode node, int depth);


    /**
     * Increment depth.
     *
     * @param depth
     *            the depth
     * @return the int
     */
    int incrementDepth(int depth);


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
    BinNode delete(
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth);
}
