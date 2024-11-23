import student.TestCase;

/**
 * The Class BinTreeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class BinTreeTest extends TestCase {

    /** The bin tree. */
    private BinTree binTree;

    /**
     * Sets the up.
     */
    @Override
    public void setUp() {
        binTree = new BinTree(1024); // Assuming a world size of 1024x1024
        binTree.insert(new Seminar(1, "Central Seminar", "2024-01-01", 30,
            (short)512, (short)512, 100, new String[] { "Central" },
            "Located centrally."));
    }


    /**
     * Test insert on boundary.
     */
    public void testInsertOnBoundary() {
        Seminar edgeSeminar = new Seminar(2, "Edge Seminar", "2024-02-02", 60,
            (short)1023, (short)1023, 200, new String[] { "Edge" },
            "On the edge.");
        binTree.insert(edgeSeminar);
        assertEquals(2, binTree.size());
        assertNull(binTree.getSeminar(1023, 1023));
        assertEquals(0, binTree.getNodesVisited());
    }


    /**
     * Test insert overlap.
     */
    public void testInsertOverlap() {
        Seminar overlapSeminar = new Seminar(3, "Overlap " + "Seminar",
            "2024-03-03", 45, (short)512, (short)512, 300, new String[] {
                "Overlap" }, "Overlapping coordinates.");
        binTree.insert(overlapSeminar);
        assertEquals(2, binTree.size()); // Should still be 2 because of overlap
        assertEquals(0, binTree.getNodesVisited()); // Check visits during
                                                    // insertion
    }


    /**
     * Test search radius.
     */
    public void testSearchRadius() {
        binTree.search(512, 512, 50); // Radius that should include the central
                                      // seminar
        assertEquals(1, binTree.getNodesVisited());
    }


    /**
     * Test delete non existent.
     */
    public void testDeleteNonExistent() {
        assertEquals(1, binTree.size()); // Size should remain unchanged
    }


    /**
     * Test clear tree.
     */
    public void testClearTree() {
        binTree.clear();
        assertEquals(1, binTree.size());
        binTree.search(512, 512, 10);
        assertEquals(1, binTree.getNodesVisited()); // No nodes should be
                                                    // visited after clear
    }
}
