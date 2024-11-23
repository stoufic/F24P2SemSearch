import java.util.Iterator;

/**
 * Seminar class with getter methods for key fields. There is probably no
 * good reason why you would want to modify this class for your project.
 *
 * @author CS3114/CS5040 staff
 * @version July 2023, last updated September 2023
 */

public class Seminar {

    /** The title. */
    private String title;

    /** The date. */
    private String date;

    /** The length. */
    private int length;

    /** The keywords. */
    private String[] keywords;

    /** The x. */
    private short x;

    /** The y. */
    private short y;

    /** The desc. */
    private String desc;

    /** The cost. */
    private int cost;

    /** The id. */
    private int id;

    /**
     * Instantiates a new seminar.
     */
    public Seminar() {
        // Constructor left intentionally empty
    }


    /**
     * Instantiates a new seminar.
     *
     * @param idin
     *            the idin
     * @param tin
     *            the tin
     * @param datein
     *            the datein
     * @param lin
     *            the lin
     * @param xin
     *            the xin
     * @param yin
     *            the yin
     * @param cin
     *            the cin
     * @param kin
     *            the kin
     * @param descin
     *            the descin
     */
    public Seminar(
        int idin,
        String tin,
        String datein,
        int lin,
        short xin,
        short yin,
        int cin,
        String[] kin,
        String descin) {
        id = idin;
        title = tin;
        date = datein;
        length = lin;
        x = xin;
        y = yin;
        cost = cin;
        keywords = kin;
        desc = descin;
    }


    /**
     * Id.
     *
     * @return the int
     */
    public int id() {
        return id;
    }


    /**
     * Title.
     *
     * @return the string
     */
    public String title() {
        return title;
    }


    /**
     * Date.
     *
     * @return the string
     */
    public String date() {
        return date;
    }


    /**
     * Length.
     *
     * @return the int
     */
    public int length() {
        return length;
    }


    /**
     * Cost.
     *
     * @return the int
     */
    public int cost() {
        return cost;
    }


    /**
     * Keywords.
     *
     * @return the string[]
     */
    public String[] keywords() {
        return keywords;
    }


    /**
     * Desc.
     *
     * @return the string
     */
    public String desc() {
        return desc;
    }


    /**
     * X.
     *
     * @return the int
     */
    public int x() {
        return x;
    }


    /**
     * Y.
     *
     * @return the int
     */
    public int y() {
        return y;
    }


    /**
     * Gets the x.
     *
     * @return the x
     */
    public short getX() {
        return x;
    }


    /**
     * Gets the y.
     *
     * @return the y
     */
    public short getY() {
        return y;
    }


    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public void setX(double x) {
        this.x = (short)x;
    }


    /**
     * Sets the y.
     *
     * @param y
     *            the new y
     */
    public void setY(double y) {
        this.y = (short)y;
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Gets the x1.
     *
     * @return the x1
     */
    public double getX1() {
        return this.x;
    }


    /**
     * Gets the y1.
     *
     * @return the y1
     */
    public double getY1() {
        return this.y;
    }


    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        StringBuilder mykeys = new StringBuilder();
        for (int i = 0; i < keywords.length; i++) {
            mykeys.append(keywords[i]);
            if (i != keywords.length - 1) {
                mykeys.append(", ");
            }
        }

        return "ID: " + id + ", Title: " + title + "\nDate: " + date
            + ", Length: " + length + ", X: " + x + ", Y: " + y + ", Cost: "
            + cost + "\nDescription: " + desc + "\nKeywords: " + mykeys;
    }


    /**
     * Iterator.
     *
     * @return the iterator
     */
    public static Iterator<Seminar> iterator() {
        return null;
    }


    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return false;
    }


    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return 0;
    }


    /**
     * Adds the.
     *
     * @param seminar
     *            the seminar
     */
    public void add(Seminar seminar) {
        return;
    }


    /**
     * Gets the.
     *
     * @param i
     *            the i
     * @return the seminar
     */
    public Seminar get(int i) {
        return null;
    }
}
