import java.util.Iterator;

/**
 * The Class LeafNode.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class LeafNode implements BinNode {

    /** The seminars. */
    private LinkedList seminars;

    /**
     * Instantiates a new leaf node.
     *
     * @param seminar
     *            the seminar
     */
    public LeafNode(Seminar seminar) {
        this.seminars = new LinkedList();
        this.seminars.add(seminar);
    }


    /**
     * Instantiates a new leaf node.
     *
     * @param seminars
     *            the seminars
     */
    public LeafNode(LinkedList seminars) {
        this.seminars = seminars;
    }


    /**
     * Gets the seminars.
     *
     * @return the seminars
     */
    public LinkedList getSeminars() {
        return seminars;
    }


    /**
     * Adds the seminar.
     *
     * @param seminar
     *            the seminar
     */
    public void addSeminar(Seminar seminar) {
        if (seminar.size() < 3) {
            seminar.add(seminar);
        }
    }


    /**
     * Checks if is leaf.
     *
     * @return true, if is leaf
     */
    @Override
    public boolean isLeaf() {
        return true;
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
        // Do nothing, leaf nodes don't have children
    }


    /**
     * Sets the right.
     *
     * @param right
     *            the new right
     */
    @Override
    public void setRight(BinNode right) {
        // Do nothing, leaf nodes don't have children
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
     * Gets the seminar.
     *
     * @return the seminar
     */
    public Seminar getSeminar() {
        return seminars.isEmpty() ? null : seminars.get(0);
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
        System.out.print("(Leaf with " + seminars.size() + " objects:");
        for (int i = 0; i < seminars.size(); i++) {
            Seminar seminar = seminars.get(i);
            System.out.print(" " + seminar.getId());
        }
        System.out.println(")");
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
        for (int i = 0; i < depth; i++) {
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
        Iterator<Seminar> it = Seminar.iterator();
        while (it.hasNext()) {
            Seminar seminar = it.next();
            if (seminar.getId() == id && seminar.getX()
                == targetX && seminar
                .getY() == targetY) {
                it.remove();
                if (seminar.isEmpty()) {
                    return EmptyNode.getInstance();
                }
                break;
            }
        }
        return this;
    }
}
