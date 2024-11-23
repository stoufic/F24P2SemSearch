/**
 * The Class InternalNode.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class InternalNode implements BinNode {

    /** The left. */
    private BinNode left;

    /** The right. */
    private BinNode right;

    /** The split on X. */
    private boolean splitOnX;

    /** The split value. */
    private int splitValue;

    /**
     * Instantiates a new internal node.
     *
     * @param left
     *            the left
     * @param right
     *            the right
     * @param splitOnX
     *            the split on X
     * @param splitValue
     *            the split value
     */
    public InternalNode(
        BinNode left,
        BinNode right,
        boolean splitOnX,
        int splitValue) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
        this.splitValue = splitValue;
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
        return left;
    }


    /**
     * Sets the left.
     *
     * @param left
     *            the new left
     */
    @Override
    public void setLeft(BinNode left) {
        this.left = left;
    }


    /**
     * Gets the right.
     *
     * @return the right
     */
    @Override
    public BinNode getRight() {
        return right;
    }


    /**
     * Sets the right.
     *
     * @param right
     *            the new right
     */
    @Override
    public void setRight(BinNode right) {
        this.right = right;
    }


    /**
     * Checks if is split on X.
     *
     * @return true, if is split on X
     */
    @Override
    public boolean isSplitOnX() {
        return splitOnX;
    }


    /**
     * Gets the split value.
     *
     * @return the split value
     */
    public int getSplitValue() {
        return splitValue;
    }


    /**
     * Sets the split value.
     *
     * @param splitValue
     *            the new split value
     */
    public void setSplitValue(int splitValue) {
        this.splitValue = splitValue;
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
        System.out.println("(I)");
        right.print(incrementDepth(depth));
        left.print(incrementDepth(depth));
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
     * Prints the indent.
     *
     * @param depth
     *            the depth
     */
    private void printIndent(int depth) {
        for (int i = 0; i < incrementDepth(depth); i++) {
            System.out.print("    ");
        }
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
        int midPoint;
        if (depth % 2 == 0) { // Splitting based on X
            midPoint = (xMin + xMax) / 2;
            if (targetX <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, midPoint,
                    yMax, plus(depth, 1));
            }
            else {
                right = right.delete(id, targetX, targetY, midPoint + 1, yMin,
                    xMax, yMax, plus(depth, 1));
            }
        }
        else { // Splitting based on Y
            midPoint = (yMin + yMax) / 2;
            if (targetY <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, xMax,
                    midPoint, depth + 1);
            }
            else {
                right = right.delete(id, targetX, targetY, xMin, midPoint + 1,
                    xMax, yMax, plus(depth, 1));
            }
        }

        if (left instanceof LeafNode && right instanceof EmptyNode) {
            return left;
        }
        else if (left instanceof EmptyNode && right instanceof LeafNode) {
            return right;
        }
        return this;
    }


    /**
     * Plus.
     *
     * @param i
     *            the i
     * @param j
     *            the j
     * @return the int
     */
    private int plus(int i, int j) {
        return i + j;
    }
}
