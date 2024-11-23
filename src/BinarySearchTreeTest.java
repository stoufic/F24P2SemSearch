import junit.framework.TestCase; // Import the TestCase base class

/**
 * The Class BinarySearchTreeTest.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class BinarySearchTreeTest extends TestCase {

    /** The bst. */
    private BinarySearchTree bst;

    /**
     * Sets the up.
     */
    // Setup for tests, creating an instance of BinarySearchTree
    public void setUp() {
        bst = new BinarySearchTree();
        // Prepopulate the tree with some data for meaningful tests
        bst.insertById(new Seminar(1, "Seminar One", "2021-01-01", 60,
            (short)10, (short)10, 100, new String[] { "Tech" },
            "A tech seminar"));
        bst.insertById(new Seminar(2, "Seminar Two", "2021-02-01", 90,
            (short)20, (short)20, 200, new String[] { "Health" },
            "A health seminar"));
        bst.insertById(new Seminar(3, "Seminar Three", "2021-03-01", 120,
            (short)30, (short)30, 300, new String[] { "Education" },
            "An education seminar"));
    }


    /**
     * Test insert.
     */
    // Test insertion of a new seminar
    public void testInsert() {
        Seminar newSeminar = new Seminar(4, "Seminar Four", "2021-04-01", 30,
            (short)40, (short)40, 400, new String[] { "Science" },
            "A science seminar");
        bst.insertById(newSeminar);
        assertEquals(4, bst.size());
        assertNotNull(bst.findById(4));
    }


    /**
     * Test delete by id.
     */
    // Test deletion by ID
    public void testDeleteById() {
        bst.removeById(2);
        assertNull(bst.findById(2));
        assertEquals(3, bst.size());
    }


    /**
     * Test find by id non existent.
     */
    // Test finding by non-existent ID
    public void testFindByIdNonExistent() {
        assertNull(bst.findById(5));
    }


    /**
     * Test search.
     */
    // Test the search functionality
    public void testSearch() {
        Seminar found = bst.findById(1);
        assertNotNull(found);
        assertEquals("Seminar One", found.title());
    }


    /**
     * Test insert with duplicate id.
     */
    // Mutation tests
    public void testInsertWithDuplicateId() {
        Seminar duplicate = new Seminar(1, "Duplicate Seminar", "2021-05-01",
            60, (short)50, (short)50, 500, new String[] { "Tech" },
            "Another tech seminar");
        bst.insertById(duplicate);
        // Should not increase size because ID is duplicate
        assertEquals(4, bst.size());
    }


    /**
     * Test find by date range.
     */
    // Logical expression mutation in findByDateRange
    public void testFindByDateRange() {
        assertTrue(bst.findByDateRange("2021-01-01", "2021-03-01"));
        assertFalse(bst.findByDateRange("2021-04-01", "2021-05-01"));
    }


    /**
     * Test boundary values.
     */
    // Testing edge cases for boundary values
    public void testBoundaryValues() {
        bst.insertById(new Seminar(-1, "Negative ID", "2020-12-31", 30,
            (short)-1, (short)-1, 0, new String[] { "None" },
            "Negative values test"));
        assertNotNull(bst.findById(-1));
        assertEquals(4, bst.size());
    }


    /**
     * Test insert and find.
     */
    public void testInsertAndFind() {
        Seminar newSeminar = new Seminar(40, "New Seminar", "2024-07-22", 45,
            (short)80, (short)80, 250, new String[] { "Innovation" },
            "A seminar on future innovations.");
        bst.insertById(newSeminar);
        assertEquals(4, bst.size());
        assertNotNull(bst.findById(40));
        assertNull(bst.findById(999)); // Testing for non-existent ID
    }


    /**
     * Test delete.
     */
    public void testDelete() {
        bst.removeById(20);
        assertNull(bst.findById(20));
    }


    /**
     * Test find by cost range mutation.
     */
    public void testFindByCostRangeMutation() {
        assertTrue(bst.findByCostRange(90, 200));
        assertFalse(bst.findByCostRange(1000, 2000));
        assertFalse(bst.findByCostRange(150, 150)); // Direct boundary testing
    }

}
