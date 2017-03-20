import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 2/22/17.
 */
public class BinarySearchTreeTest {
    protected BinarySearchTree emptyTree;
    protected BinarySearchTree oneTree;
    protected BinarySearchTree threeTree;

    protected BinarySearchTreeNode threeTreeRoot;
    protected BinarySearchTreeNode threeTreeLeft;
    protected BinarySearchTreeNode threeTreeRight;

    @org.junit.Before
    public void setUp() throws Exception {
        emptyTree = new BinarySearchTree();
        oneTree   = new BinarySearchTree(new BinarySearchTreeNode(20));

        threeTreeRoot = new BinarySearchTreeNode(new Integer(15));
        threeTreeLeft = new BinarySearchTreeNode(new Integer(7));
        threeTreeRight = new BinarySearchTreeNode(new Integer(20));

        threeTreeRoot.left  = threeTreeLeft;
        threeTreeRoot.right = threeTreeRight;

        threeTree = new BinarySearchTree(threeTreeRoot);
    }

    @Test
    public void BinarySearchTreeConstructorTest() {
        assertNotNull(emptyTree);
        assertNotNull(oneTree);
        assertNotNull(oneTree.root);
        assertNotNull(threeTree.root);
    }

    @Test
    public void getRootTest() {
        assertNotNull(oneTree.getRoot());
        assertEquals(new Integer(15), ((BinarySearchTreeNode) threeTree.getRoot()).getData());
    }

    @Test
    public void insertTest() {
        oneTree.insert(new Integer(15));
        assertEquals(new Integer(15),
                ((BinarySearchTreeNode) oneTree.getRoot()).getLeft().getData());
    }

    @Test
    public void searchTest() {
        assertSame( threeTreeRoot,
                threeTree.search( new Integer(15) ) );
        assertSame( threeTreeLeft,
                threeTree.search(new Integer(7)));
        assertSame( threeTreeRight,
                threeTree.search(new Integer(20)));
        assertSame( null,
                threeTree.search(new Integer(25)));

    }
}