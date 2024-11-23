/**
 * The Class BSTNode.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class BSTNode {

    /** The element. */
    private Object element;

    /** The left. */
    private BSTNode left;

    /** The right. */
    private BSTNode right;

    /** The seminar. */
    private Seminar seminar;

    /** The string value. */
    private String stringValue;

    /**
     * Instantiates a new BST node.
     */
    public BSTNode() {
        this(null, null);
    }


    /**
     * Instantiates a new BST node.
     *
     * @param element
     *            the element
     * @param seminar
     *            the seminar
     */
    public BSTNode(Object element, Seminar seminar) {
        this(element, null, null, seminar);
    }


    /**
     * Instantiates a new BST node.
     *
     * @param element
     *            the element
     * @param left
     *            the left
     * @param right
     *            the right
     * @param seminar
     *            the seminar
     */
    public BSTNode(
        Object element,
        BSTNode left,
        BSTNode right,
        Seminar seminar) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.seminar = seminar;
    }


    /**
     * Gets the seminar.
     *
     * @return the seminar
     */
    public Seminar getSeminar() {
        return seminar;
    }


    /**
     * Sets the seminar.
     *
     * @param seminar
     *            the new seminar
     */
    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }


    /**
     * Gets the element.
     *
     * @return the element
     */
    public String getElement() {
        return (String)element;
    }


    /**
     * Sets the element.
     *
     * @param element
     *            the new element
     */
    public void setElement(String element) {
        this.element = element;
    }


    /**
     * Gets the left.
     *
     * @return the left
     */
    public BSTNode getLeft() {
        return left;
    }


    /**
     * Sets the left.
     *
     * @param left
     *            the new left
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }


    /**
     * Gets the right.
     *
     * @return the right
     */
    public BSTNode getRight() {
        return right;
    }


    /**
     * Sets the right.
     *
     * @param right
     *            the new right
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }


    /**
     * Checks if is leaf.
     *
     * @return true, if is leaf
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }


    /**
     * Sem value.
     *
     * @return the seminar
     */
    public Seminar semValue() {
        return this.seminar;
    }


    /**
     * Sets the value.
     *
     * @param semValue
     *            the new value
     */
    // Setter for seminar value
    public void setValue(Seminar semValue) {
        this.seminar = semValue;
    }


    /**
     * String value.
     *
     * @return the string
     */
    // Getter for string value (may represent a keyword or any other string
    // information)
    public String stringValue() {
        return stringValue();
    }


    /**
     * Sets the string value.
     *
     * @param value
     *            the new string value
     */
    // Setter for string value
    public void setStringValue(String value) {
        this.stringValue = value;
    }
}
