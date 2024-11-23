/**
 * The Class BinTree.
 * 
 * @author toufi
 * @version 10.20.24
 */

public class BinTree {

    /** The root. */
    private BinNode root;

    /** The size. */
    private int size;

    /** The nodes visited. */
    private int nodesVisited;

    /** The world size. */
    private final int worldSize;

    /** The Constant FLYWEIGHT. */
    private static final EmptyNode FLYWEIGHT = EmptyNode.getInstance();

    /**
     * Instantiates a new bin tree.
     *
     * @param worldSize
     *            the world size
     */
    public BinTree(int worldSize) {
        this.root = FLYWEIGHT;
        this.size = 0;
        this.worldSize = worldSize;
    }


    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return size;
    }


    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Insert.
     *
     * @param seminar
     *            the seminar
     */
    public void insert(Seminar seminar) {
        if (root == FLYWEIGHT) {
            root = new LeafNode(seminar);
        }
        else {
            root = insertHelper(root, seminar, 0, 0, 0, worldSize, worldSize);
        }
        size++;
    }


    /**
     * Insert helper.
     *
     * @param node
     *            the node
     * @param seminar
     *            the seminar
     * @param depth
     *            the depth
     * @param x
     *            the x
     * @param y
     *            the y
     * @param width
     *            the width
     * @param height
     *            the height
     * @return the bin node
     */
    private BinNode insertHelper(
        BinNode node,
        Seminar seminar,
        int depth,
        int x,
        int y,
        int width,
        int height) {
        if (node instanceof EmptyNode) {
            return new LeafNode(seminar);
        }

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            if (leaf.getSeminar().x() == seminar.x() && leaf.getSeminar()
                .y() == seminar.y()) {
                leaf.addSeminar(seminar);
                return leaf;
            }

            boolean splitOnX = depth % 2 == 0;
            int splitValue = splitOnX ? x + width / 2 : y + height / 2;
            InternalNode newNode = new InternalNode(FLYWEIGHT, FLYWEIGHT,
                splitOnX, splitValue);
            LinkedList seminars = new LinkedList();
            for (int i = 0; i < leaf.getSeminars().size(); i++) {
                seminars.add(leaf.getSeminars().get(i));
            }
            seminars.add(seminar);

            for (int i = 0; i < seminars.size(); i++) {
                Seminar s = seminars.get(i);
                if (splitOnX) {
                    if (s.getX() < splitValue) {
                        newNode.setLeft(insertHelper(newNode.getLeft(), s, depth
                            + 1, x, y, splitValue - x, height));
                    }
                    else {
                        newNode.setRight(insertHelper(newNode.getRight(), s,
                            depth + 1, splitValue, y, width - (splitValue - x),
                            height));
                    }
                }
                else {
                    if (s.getY() < splitValue) {
                        newNode.setLeft(insertHelper(newNode.getLeft(), s, depth
                            + 1, x, y, width, splitValue - y));
                    }
                    else {
                        newNode.setRight(insertHelper(newNode.getRight(), s,
                            depth + 1, x, splitValue, width, height
                                - (splitValue - y)));
                    }
                }
            }

            return newNode;
        }

        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            boolean splitOnX = internal.isSplitOnX();
            int splitValue = internal.getSplitValue();

            if (splitOnX) {
                if (seminar.getX() < splitValue) {
                    internal.setLeft(insertHelper(internal.getLeft(), seminar,
                        depth + 1, x, y, splitValue - x, height));
                }
                else {
                    internal.setRight(insertHelper(internal.getRight(), seminar,
                        depth + 1, splitValue, y, width - (splitValue - x),
                        height));
                }
            }
            else {
                if (seminar.getY() < splitValue) {
                    internal.setLeft(insertHelper(internal.getLeft(), seminar,
                        depth + 1, x, y, width, splitValue - y));
                }
                else {
                    internal.setRight(insertHelper(internal.getRight(), seminar,
                        depth + 1, x, splitValue, width, height - (splitValue
                            - y)));
                }
            }
            return internal;
        }

        return FLYWEIGHT;
    }


    /**
     * Search.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param radius
     *            the radius
     */
    public void search(int x, int y, int radius) {
        searchHelper(root, x, y, radius, 0, 0, 0, worldSize - 1, worldSize - 1);
    }


    /**
     * Search helper.
     *
     * @param node
     *            the node
     * @param targetX
     *            the target X
     * @param targetY
     *            the target Y
     * @param radius
     *            the radius
     * @param depth
     *            the depth
     * @param xMin
     *            the x min
     * @param yMin
     *            the y min
     * @param xMax
     *            the x max
     * @param yMax
     *            the y max
     */
    private void searchHelper(
        BinNode node,
        int targetX,
        int targetY,
        int radius,
        int depth,
        int xMin,
        int yMin,
        int xMax,
        int yMax) {
        nodesVisited++;
        if (node instanceof EmptyNode) {
            return;
        }

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            LinkedList seminars = leaf.getSeminars();
            for (int i = 0; i < seminars.size(); i++) {
                Seminar seminar = seminars.get(i);
                if (inRange(seminar.getX(), seminar.getY(), targetX, targetY,
                    radius)) {
                    System.out.println("Found a record with key value "
                        + seminar.id() + " at " + seminar.x() + ", " + seminar
                            .y());
                }
            }
            return;
        }

        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            boolean splitOnX = (depth % 2 == 0);
            int midPoint = splitOnX ? (xMin + xMax) / 2 : (yMin + yMax) / 2;
            boolean checkLeft = (splitOnX
                ? (targetX - radius <= midPoint)
                : (targetY - radius <= midPoint));
            boolean checkRight = (splitOnX
                ? (targetX + radius > midPoint)
                : (targetY + radius > midPoint));

            if (checkLeft) {
                int newXMax = splitOnX ? midPoint : xMax;
                int newYMax = splitOnX ? yMax : midPoint;
                searchHelper(internal.getLeft(), targetX, targetY, radius, depth
                    + 1, xMin, yMin, newXMax, newYMax);
            }
            if (checkRight) {
                int newXMin = splitOnX ? midPoint + 1 : xMin;
                int newYMin = splitOnX ? yMin : midPoint + 1;
                searchHelper(internal.getRight(), targetX, targetY, radius,
                    depth + 1, newXMin, newYMin, xMax, yMax);
            }
        }
    }


    /**
     * Delete.
     *
     * @param targetX
     *            the target X
     * @param targetY
     *            the target Y
     * @param id
     *            the id
     */
    public void delete(int targetX, int targetY, int id) {
        BinNode oldRoot = root;
        root = root.delete(id, targetX, targetY, 0, 0, worldSize - 1, worldSize
            - 1, 0);
        if (root instanceof EmptyNode) {
            root = EmptyNode.getInstance();
            size = 0;
        }
        else if (oldRoot != root) {
            size--;
        }
    }


    /**
     * In range.
     *
     * @param seminarX
     *            the seminar X
     * @param seminarY
     *            the seminar Y
     * @param x
     *            the x
     * @param y
     *            the y
     * @param radius
     *            the radius
     * @return true, if successful
     */
    private boolean inRange(
        int seminarX,
        int seminarY,
        int x,
        int y,
        int radius) {
        int dx = seminarX - x;
        int dy = seminarY - y;
        return (dx * dx + dy * dy) <= (radius * radius);
    }


    /**
     * Gets the nodes visited.
     *
     * @return the nodes visited
     */
    public int getNodesVisited() {
        return nodesVisited;
    }


    /**
     * Reset nodes visited.
     */
    public void resetNodesVisited() {
        nodesVisited = 0;
    }


    /**
     * Prints the tree.
     */
    public void printTree() {
        System.out.println("Location Tree:");
        if (root == FLYWEIGHT) {
            System.out.println("E");
        }
        else {
            root.print(calculateHeight(root));
        }
    }


    /**
     * Calculate height.
     *
     * @param node
     *            the node
     * @return the int
     */
    private int calculateHeight(BinNode node) {
        if (node == null || node instanceof EmptyNode) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(
            node.getRight()));
    }


    /**
     * Gets the seminar.
     *
     * @param i
     *            the i
     * @param j
     *            the j
     * @return the seminar
     */
    public Object getSeminar(int i, int j) {
        return null;
    }


    /**
     * Clear.
     */
    public void clear() {
        return;
    }
}
