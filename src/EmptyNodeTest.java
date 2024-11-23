import student.TestCase;

/**
 * The Class EmptyNodeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class EmptyNodeTest extends TestCase {

    /** The empty node. */
    private EmptyNode emptyNode;

    /**
     * Sets the up.
     */
    @Override
    protected void setUp() {
        emptyNode = EmptyNode.getInstance();
    }


    /**
     * Test singleton behavior.
     */
    public void testSingletonBehavior() {
        // Ensure that multiple calls to getInstance return the same object
        assertSame(emptyNode, EmptyNode.getInstance());
    }


    /**
     * Test leaf behavior.
     */
    public void testLeafBehavior() {
        // EmptyNode should not be considered a leaf
        assertFalse(emptyNode.isLeaf());
    }


    /**
     * Test get seminar.
     */
    public void testGetSeminar() {
        // Should return null as there are no seminars associated with an empty
        // node
        assertNull(emptyNode.getSeminar());
    }


    /**
     * Test child nodes.
     */
    public void testChildNodes() {
        // All child getters should return null
        assertNull(emptyNode.getLeft());
        assertNull(emptyNode.getRight());
    }


    /**
     * Test set child nodes.
     */
    public void testSetChildNodes() {
        // Setting children should not change anything, nodes should remain null
        emptyNode.setLeft(new LeafNode(new Seminar()));
        emptyNode.setRight(new LeafNode(new Seminar()));
        assertNull(emptyNode.getLeft());
        assertNull(emptyNode.getRight());
    }


    /**
     * Test split on X.
     */
    public void testSplitOnX() {
        // Should always return false as it does not split
        assertFalse(emptyNode.isSplitOnX());
    }
}
