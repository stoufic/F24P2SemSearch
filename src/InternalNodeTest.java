import student.TestCase;

/**
 * The Class InternalNodeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class InternalNodeTest extends TestCase {

    /** The internal node. */
    private InternalNode internalNode;

    /**
     * Sets the up.
     */
    @Override
    protected void setUp() {
        internalNode = new InternalNode(EmptyNode.getInstance(), EmptyNode
            .getInstance(), true, 50);
    }


    /**
     * Test is leaf.
     */
    public void testIsLeaf() {
        // InternalNode is never a leaf
        assertFalse(internalNode.isLeaf());
    }


    /**
     * Test child handling.
     */
    public void testChildHandling() {
        // Should correctly handle child nodes
        BinNode left = new LeafNode(new Seminar());
        BinNode right = new LeafNode(new Seminar());
        internalNode.setLeft(left);
        internalNode.setRight(right);

        assertSame(left, internalNode.getLeft());
        assertSame(right, internalNode.getRight());
    }


    /**
     * Test split properties.
     */
    public void testSplitProperties() {
        assertTrue(internalNode.isSplitOnX());
        assertEquals(50, internalNode.getSplitValue());
    }
}
