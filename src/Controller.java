/**
 * The Class Controller.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class Controller {

    /** The id tree. */
    private BinarySearchTree idTree;

    /** The date tree. */
    private BinarySearchTree dateTree;

    /** The cost tree. */
    private BinarySearchTree costTree;

    /** The keyword tree. */
    private BinarySearchTree keywordTree;

    /** The location tree. */
    private BinTree locationTree;

    /** The world size. */
    private int worldSize;

    /**
     * Instantiates a new controller.
     *
     * @param worldSize
     *            the world size
     */
    public Controller(int worldSize) {
        setIdTree(new BinarySearchTree());
        dateTree = new BinarySearchTree();
        costTree = new BinarySearchTree();
        keywordTree = new BinarySearchTree();
        locationTree = new BinTree(worldSize);
        this.worldSize = worldSize;
    }


    /**
     * Insert.
     *
     * @param seminar
     *            the seminar
     */
    public void insert(Seminar seminar) {
        if (seminar.x() < 0 || seminar.y() < 0 || seminar.x() >= worldSize
            || seminar.y() >= worldSize) {
            System.out.println("Insert FAILED - Bad x, y coordinates: "
                + seminar.x() + ", " + seminar.y());
            return;
        }

        if (getIdTree().find(seminar)) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + seminar
                    .id());
            return;
        }

        getIdTree().insertById(seminar);
        dateTree.insertByDate(seminar);
        costTree.insertByCost(seminar);
        keywordTree.insertByKeyword(seminar);
        locationTree.insert(seminar);

        System.out.println("Successfully inserted record with ID " + seminar
            .id());
    }


    /**
     * Delete.
     *
     * @param id
     *            the id
     */
    public void delete(int id) {
        Seminar seminar = getIdTree().findById(id);
        if (seminar != null) {
            getIdTree().removeById(id);
            dateTree.removeByDate(seminar);
            costTree.removeByCost(seminar);
            keywordTree.removeByKeyword(id, seminar);
            locationTree.delete(seminar.getX(), seminar.getY(), id);

            System.out.println("Record with ID " + id
                + " successfully deleted from the database");
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + id);
        }
    }


    /**
     * Search by id.
     *
     * @param id
     *            the id
     */
    public void searchById(int id) {
        Seminar seminar = getIdTree().findById(id);
        if (seminar != null) {
            System.out.println("Found record with ID " + id + ":");
            System.out.println(seminar);
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
    }


    /**
     * Search by keyword.
     *
     * @param keyword
     *            the keyword
     */
    public void searchByKeyword(String keyword) {
        String found = keywordTree.findByKeyword(keyword);
        if (!found.equals("")) {
            System.out.println("Seminars matching keyword " + keyword + ":\n"
                + found);
        }
    }


    /**
     * Search by cost range.
     *
     * @param low
     *            the low
     * @param high
     *            the high
     */
    public void searchByCostRange(int low, int high) {
        boolean found = costTree.findByCostRange(low, high);
        System.out.println("Seminars with costs in range " + low + " to " + high
            + ":");
        if (found) {
            System.out.println("Matching records found.");
        }
        else {
            System.out.println("No matching records.");
        }
    }


    /**
     * Search by date range.
     *
     * @param low
     *            the low
     * @param high
     *            the high
     */
    public void searchByDateRange(String low, String high) {
        boolean found = dateTree.findByDateRange(low, high);
        System.out.println("Seminars with dates in range " + low + " to " + high
            + ":");
        if (found) {
            System.out.println("Matching records found.");
        }
        else {
            System.out.println("No matching records.");
        }
    }


    /**
     * Search by location.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param radius
     *            the radius
     */
    public void searchByLocation(int x, int y, int radius) {
        locationTree.search(x, y, radius);
        System.out.println("Seminars within " + radius + " units of " + x + ", "
            + y + " found.");
    }


    /**
     * Prints the.
     *
     * @param field
     *            the field
     */
    public void print(String field) {
        BinarySearchTree tree = null;
        switch (field) {
            case "ID":
                tree = getIdTree();
                break;
            case "date":
                tree = dateTree;
                break;
            case "cost":
                tree = costTree;
                break;
            case "keyword":
                tree = keywordTree;
                break;
            default:
                System.out.println("Invalid field: " + field);
                return;
        }

        if (tree != null && tree.getRoot() != null) {
            System.out.println(field + " Tree:");
            printIndented(tree, (BSTNode)tree.getRoot(), 0, calculateHeight(
                (BSTNode)tree.getRoot()), field);
        }
        else {
            System.out.println(field + " Tree is empty");
        }
    }


    /**
     * Prints the indented.
     *
     * @param tree
     *            the tree
     * @param node
     *            the node
     * @param level
     *            the level
     * @param height
     *            the height
     * @param field
     *            the field
     */
    private void printIndented(
        BinarySearchTree tree,
        BSTNode node,
        int level,
        int height,
        String field) {
        if (node == null) {
            return;
        }

        printIndented(tree, node.getLeft(), level + 1, height, field);
        System.out.println(" ".repeat(Math.max(0, (height - level) * 4))
            + getNodeValue(node, field));
        printIndented(tree, node.getRight(), level + 1, height, field);
    }


    /**
     * Gets the node value.
     *
     * @param node
     *            the node
     * @param field
     *            the field
     * @return the node value
     */
    private String getNodeValue(BSTNode node, String field) {
        switch (field) {
            case "ID":
                return String.valueOf(node.semValue().id());
            case "date":
                return node.semValue().date();
            case "cost":
                return String.valueOf(node.semValue().cost());
            case "keyword":
                return String.valueOf(node.stringValue());
            default:
                return "Invalid";
        }
    }


    /**
     * Calculate height.
     *
     * @param node
     *            the node
     * @return the int
     */
    private int calculateHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(
            node.getRight()));
    }


    /**
     * Gets the id tree.
     *
     * @return the id tree
     */
    public BinarySearchTree getIdTree() {
        return idTree;
    }


    /**
     * Sets the id tree.
     *
     * @param idTree
     *            the new id tree
     */
    public void setIdTree(BinarySearchTree idTree) {
        this.idTree = idTree;
    }
}
