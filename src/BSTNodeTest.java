import static org.junit.Assert.assertNotEquals;
import student.TestCase;

/**
 * The Class BSTNodeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class BSTNodeTest extends TestCase {

    /** The node. */
    private BSTNode node;

    /** The seminar. */
    private Seminar seminar;

    /**
     * Sets the up.
     */
    @Override
    public void setUp() {
        seminar = new Seminar(1, "Seminar", "2024-01-01", 120, (short)10,
            (short)10, 100, new String[] { "Tech" }, "Description");
        node = new BSTNode("Keyword", node, node, seminar);
    }


    /**
     * Test node properties.
     */
    public void testNodeProperties() {

        BSTNode newNode = new BSTNode();
        assertNull(newNode.semValue());
    }


    /**
     * Test setters.
     */
    public void testSetters() {
        Seminar newSeminar = new Seminar(2, "Updated Seminar", "2024-01-02",
            150, (short)20, (short)20, 200, new String[] { "Health" },
            "Updated description");
        node.setValue(newSeminar);
        assertEquals(newSeminar, node.semValue());

    }


    /**
     * Test leaf node properties.
     */
    public void testLeafNodeProperties() {
        BSTNode leafNode = new BSTNode();
        assertTrue(leafNode.isLeaf());
    }
}
