/**
 * The Class BinarySearchTree.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class BinarySearchTree {

    /** The root. */
    private BSTNode root;

    /** The nodecount. */
    private int nodecount;

    /** The traversal count. */
    private int traversalCount = 0;

    /**
     * Instantiates a new binary search tree.
     */
    public BinarySearchTree() {
        root = null;
        nodecount = 0;
    }


    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return nodecount;
    }


    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the seminar
     */
    public Seminar findById(int id) {
        return findByIdHelp(root, id);
    }


    /**
     * Find by id help.
     *
     * @param rt
     *            the rt
     * @param id
     *            the id
     * @return the seminar
     */
    private Seminar findByIdHelp(BSTNode rt, int id) {
        if (isNull(rt)) {
            return null;
        }
        if (rt.semValue().id() > id) {
            return findByIdHelp(rt.getLeft(), id);
        }
        else if (rt.semValue().id() == id) {
            return rt.semValue();
        }
        else {
            return findByIdHelp(rt.getRight(), id);
        }
    }


    /**
     * Find by date range.
     *
     * @param low
     *            the low
     * @param high
     *            the high
     * @return true, if successful
     */
    public boolean findByDateRange(String low, String high) {
        return findByDateRangeHelper(root, low, high);
    }


    /**
     * Find by date range helper.
     *
     * @param rt
     *            the rt
     * @param low
     *            the low
     * @param high
     *            the high
     * @return true, if successful
     */
    private boolean findByDateRangeHelper(BSTNode rt, String low, String high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (low.equals(high) && isEquals(rt.semValue().date().compareTo(low),
            0)) {
            found |= findByDateRangeHelper(rt.getLeft(), low, high);
            if (rt.semValue().date().compareTo(low) >= 0 && rt.semValue().date()
                .compareTo(high) <= 0) {
                System.out.println(rt.semValue());
                found = true;
            }
        }
        else {
            if (rt.semValue().date().compareTo(low) >= 0) {
                found |= findByDateRangeHelper(rt.getLeft(), low, high);
            }

            if (rt.semValue().date().compareTo(low) >= 0 && rt.semValue().date()
                .compareTo(high) <= 0) {
                System.out.println(rt.semValue());
                found = true;
            }
            if (rt.semValue().date().compareTo(high) <= 0) {
                found |= findByDateRangeHelper(rt.getRight(), low, high);
            }
        }

        return found;
    }


    /**
     * Find by cost range.
     *
     * @param low
     *            the low
     * @param high
     *            the high
     * @return true, if successful
     */
    public boolean findByCostRange(int low, int high) {
        return findByCostRangeHelper(root, low, high);
    }


    /**
     * Find by cost range helper.
     *
     * @param rt
     *            the rt
     * @param low
     *            the low
     * @param high
     *            the high
     * @return true, if successful
     */
    private boolean findByCostRangeHelper(BSTNode rt, int low, int high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (low == high && isEquals(rt.semValue().cost(), low)) {
            found |= findByCostRangeHelper(rt.getLeft(), low, high);
            if (rt.semValue().cost() >= low && rt.semValue().cost() <= high) {
                System.out.println(rt.semValue());
                found = true;
            }
        }
        else {
            if (rt.semValue().cost() >= low) {
                found |= findByCostRangeHelper(rt.getLeft(), low, high);
            }
            if (rt.semValue().cost() >= low && rt.semValue().cost() <= high) {
                System.out.println(rt.semValue());
                found = true;
            }
            if (rt.semValue().cost() <= high) {
                found |= findByCostRangeHelper(rt.getRight(), low, high);
            }
        }

        return found;
    }


    /**
     * Checks if is equals.
     *
     * @param cost
     *            the cost
     * @param low
     *            the low
     * @return true, if is equals
     */
    private boolean isEquals(int cost, int low) {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * Find by keyword.
     *
     * @param keyword
     *            the keyword
     * @return the string
     */
    public String findByKeyword(String keyword) {
        return findByKeywordHelper(root, keyword);
    }


    /**
     * Find by keyword helper.
     *
     * @param rt
     *            the rt
     * @param keyword
     *            the keyword
     * @return the string
     */
    private String findByKeywordHelper(BSTNode rt, String keyword) {
        String result = "";
        if (isNull(rt)) {
            return "";
        }

        if (rt.stringValue().equals(keyword)) {
            result = "ID: " + rt.semValue().id() + ", Title: " + rt.semValue()
                .title() + "\r\n" + "Date: " + rt.semValue().date()
                + ", Length: " + rt.semValue().length() + ", X: " + rt
                    .semValue().x() + ", Y: " + rt.semValue().y() + ", Cost: "
                + rt.semValue().cost() + "\r\n" + "Description: " + rt
                    .semValue().desc() + "\r\n" + "Keywords: ";

            for (String kywd : rt.semValue().keywords()) {
                if (kywd.equals(rt.semValue().keywords()[0])) {
                    result = result + (kywd);
                }
                else {
                    result = result + ", " + kywd;
                }
            }
            result = result + "\n";
        }

        String foundInLeft = findByKeywordHelper(rt.getLeft(), keyword);
        result = foundInLeft + result;
        String foundInRight = findByKeywordHelper(rt.getRight(), keyword);
        result = foundInRight + result;

        return result;
    }


    /**
     * Find.
     *
     * @param seminar
     *            the seminar
     * @return true, if successful
     */
    public boolean find(Seminar seminar) {
        return findHelp(root, seminar) != null;
    }


    /**
     * Find help.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode findHelp(BSTNode rt, Seminar seminar) {
        if (rt == null) {
            return null;
        }
        BSTNode temp = rt;

        if (seminar.id() != rt.semValue().id()) {
            if (seminar.id() < rt.semValue().id()) {
                temp = findHelp(rt.getLeft(), seminar);
            }
            else {
                temp = findHelp(rt.getRight(), seminar);
            }
        }
        else {
            return temp;
        }

        return temp;
    }


    /**
     * Insert by id.
     *
     * @param seminar
     *            the seminar
     */
    public void insertById(Seminar seminar) {
        root = insertByIdHelp(root, seminar);
    }


    /**
     * Insert by id help.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode insertByIdHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }

        if (seminar.id() < (rt.semValue().id())) {
            rt.setLeft(insertByIdHelp(rt.getLeft(), seminar));
        }
        else {
            rt.setRight(insertByIdHelp(rt.getRight(), seminar));
        }

        return rt;
    }


    /**
     * Insert by date.
     *
     * @param seminar
     *            the seminar
     */
    public void insertByDate(Seminar seminar) {
        root = insertByDateHelp(root, seminar);
    }


    /**
     * Insert by date help.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode insertByDateHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }

        if (seminar.date().compareTo(rt.semValue().date()) <= 0) {
            rt.setLeft(insertByDateHelp(rt.getLeft(), seminar));
        }
        else {
            rt.setRight(insertByDateHelp(rt.getRight(), seminar));
        }
        return rt;
    }


    /**
     * Insert by cost.
     *
     * @param seminar
     *            the seminar
     */
    public void insertByCost(Seminar seminar) {
        root = insertByCostHelp(root, seminar);
    }


    /**
     * Insert by cost help.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode insertByCostHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }
        else if (seminar.cost() <= rt.semValue().cost()) {
            rt.setLeft(insertByCostHelp(rt.getLeft(), seminar));
        }
        else {
            rt.setRight(insertByCostHelp(rt.getRight(), seminar));
        }
        return rt;
    }


    /**
     * Insert by keyword.
     *
     * @param seminar
     *            the seminar
     */
    public void insertByKeyword(Seminar seminar) {
        for (String keyword : seminar.keywords()) {
            root = insertByKeywordHelp(root, keyword, seminar);
        }
    }


    /**
     * Insert by keyword help.
     *
     * @param rt
     *            the rt
     * @param keywords
     *            the keywords
     * @param sem
     *            the sem
     * @return the BST node
     */
    private BSTNode insertByKeywordHelp(
        BSTNode rt,
        String keywords,
        Seminar sem) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(keywords, sem);
        }
        if (keywords.compareTo(rt.stringValue()) <= 0) {
            rt.setLeft(insertByKeywordHelp(rt.getLeft(), keywords, sem));
        }
        else {
            rt.setRight(insertByKeywordHelp(rt.getRight(), keywords, sem));
        }
        return rt;
    }


    /**
     * Checks if is null.
     *
     * @param rt
     *            the rt
     * @return true, if is null
     */
    private boolean isNull(BSTNode rt) {
        return rt == null;
    }


    /**
     * Reset traversal count.
     */
    public void resetTraversalCount() {
        traversalCount = 0;
    }


    /**
     * Gets the traversal count.
     *
     * @return the traversal count
     */
    public String getTraversalCount() {
        return Integer.toString(traversalCount);
    }


    /**
     * Gets the root.
     *
     * @return the root
     */
    public Object getRoot() {
        return root;
    }


    /**
     * Removes the by id.
     *
     * @param id
     *            the id
     */
    public void removeById(int id) {
        root = removeByIdHelper(root, id);
    }


    /**
     * Removes the by id helper.
     *
     * @param rt
     *            the rt
     * @param id
     *            the id
     * @return the BST node
     */
    private BSTNode removeByIdHelper(BSTNode rt, int id) {
        if (isNull(rt)) {
            return null;
        }
        if (id < rt.semValue().id()) {
            rt.setLeft(removeByIdHelper(rt.getLeft(), id));
        }
        else if (id > rt.semValue().id()) {
            rt.setRight(removeByIdHelper(rt.getRight(), id));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                BSTNode temp = findMin(rt.getRight());
                rt.setValue(temp.semValue());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
        return rt;
    }


    /**
     * Find min.
     *
     * @param rt
     *            the rt
     * @return the BST node
     */
    private BSTNode findMin(BSTNode rt) {
        while (!isNull(rt.getLeft())) {
            rt = rt.getLeft();
        }
        return rt;
    }


    /**
     * Delete min.
     *
     * @param rt
     *            the rt
     * @return the BST node
     */
    private BSTNode deleteMin(BSTNode rt) {
        if (isNull(rt.getLeft())) {
            return rt.getRight();
        }
        rt.setLeft(deleteMin(rt.getLeft()));
        return rt;
    }


    /**
     * Removes the by date.
     *
     * @param seminar
     *            the seminar
     */
    public void removeByDate(Seminar seminar) {
        root = removeByDateHelper(root, seminar);
    }


    /**
     * Removes the by date helper.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode removeByDateHelper(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            return null;
        }
        int compare = seminar.date().compareTo(rt.semValue().date());
        if (compare < 0) {
            rt.setLeft(removeByDateHelper(rt.getLeft(), seminar));
        }
        else if (compare > 0) {
            rt.setRight(removeByDateHelper(rt.getRight(), seminar));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                BSTNode temp = findMin(rt.getRight());
                rt.setValue(temp.semValue());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
        return rt;
    }


    /**
     * Removes the by cost.
     *
     * @param seminar
     *            the seminar
     */
    public void removeByCost(Seminar seminar) {
        root = removeByCostHelper(root, seminar);
    }


    /**
     * Removes the by cost helper.
     *
     * @param rt
     *            the rt
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode removeByCostHelper(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            return null;
        }
        if (seminar.cost() < rt.semValue().cost()) {
            rt.setLeft(removeByCostHelper(rt.getLeft(), seminar));
        }
        else if (seminar.cost() > rt.semValue().cost()) {
            rt.setRight(removeByCostHelper(rt.getRight(), seminar));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                BSTNode temp = findMin(rt.getRight());
                rt.setValue(temp.semValue());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
        return rt;
    }


    /**
     * Removes the by keyword.
     *
     * @param id
     *            the id
     * @param seminar
     *            the seminar
     */
    public void removeByKeyword(int id, Seminar seminar) {
        root = removeByKeywordHelper(root, id, seminar);
    }


    /**
     * Removes the by keyword helper.
     *
     * @param rt
     *            the rt
     * @param id
     *            the id
     * @param seminar
     *            the seminar
     * @return the BST node
     */
    private BSTNode removeByKeywordHelper(BSTNode rt, int id, Seminar seminar) {
        if (isNull(rt)) {
            return null;
        }
        if (id < rt.semValue().id()) {
            rt.setLeft(removeByKeywordHelper(rt.getLeft(), id, seminar));
        }
        else if (id > rt.semValue().id()) {
            rt.setRight(removeByKeywordHelper(rt.getRight(), id, seminar));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                BSTNode temp = findMin(rt.getRight());
                rt.setValue(temp.semValue());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
        return rt;
    }
}
