import static org.junit.Assert.assertNotEquals;
import student.TestCase;

/**
 * The Class LeafNodeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class LeafNodeTest extends TestCase {

    /** The leaf node. */
    private LeafNode leafNode;

    /** The seminar. */
    private Seminar seminar;

    /**
     * Sets the up.
     */
    @Override
    protected void setUp() {
        seminar = new Seminar(1, "Leaf Seminar", "2024-01-01", 30, (short)10,
            (short)10, 100, new String[] { "Leaf" }, "Located at a leaf.");
        leafNode = new LeafNode(new LinkedList());
    }


    /**
     * Test leaf properties.
     */
    public void testLeafProperties() {
        assertTrue(leafNode.isLeaf());
        assertNull(leafNode.getSeminar());
        assertNotEquals(seminar, leafNode.getSeminar());
    }


    /**
     * Test no children.
     */
    public void testNoChildren() {
        // Leaf nodes should not have children
        assertNull(leafNode.getLeft());
        assertNull(leafNode.getRight());
    }


    /**
     * Test seminar handling.
     */
    public void testSeminarHandling() {
        // Should handle seminar operations correctly
        Seminar anotherSeminar = new Seminar(2, "Another Seminar", "2024-02-02",
            60, (short)20, (short)20, 200, new String[] { "Another" },
            "Another seminar.");
        leafNode.addSeminar(anotherSeminar);
        assertFalse(leafNode.getSeminars().contains(anotherSeminar));
        assertNotEquals(2, leafNode.getSeminars().size());
    }
}
