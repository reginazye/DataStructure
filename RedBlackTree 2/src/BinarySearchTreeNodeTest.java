import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 2/22/17.
 */
public class BinarySearchTreeNodeTest {
    protected BinarySearchTreeNode emptyNode;
    protected BinarySearchTreeNode oneNode;
    protected BinarySearchTreeNode dataNode;

    @org.junit.Before
    public void setUp() throws Exception {
        emptyNode = new BinarySearchTreeNode();

        oneNode = new BinarySearchTreeNode(new Integer(19));

        dataNode  = new BinarySearchTreeNode(new Integer(20));
        dataNode.parent = null;
        dataNode.left   = new BinarySearchTreeNode(new Integer(15));
        dataNode.left.parent = dataNode;
        dataNode.right  = new BinarySearchTreeNode(new Integer(45));
        dataNode.right.parent = dataNode;
    }

    @Test
    public void BinarySearchTreeConstructorTest() {

        assertNotNull(emptyNode);
        assertNotNull(dataNode);
        assertEquals(new Integer(20), (Integer) dataNode.data);
    }

    @Test
    public void GetSetTest() {
        emptyNode.setData(new Integer(20));
        emptyNode.setLeft(dataNode);
        BinarySearchTreeNode testNode = new BinarySearchTreeNode();
        emptyNode.setRight(testNode);

        assertEquals(new Integer(20), emptyNode.getData());
        assertSame(testNode, emptyNode.getRight());
        assertSame(dataNode, emptyNode.getLeft());

        assertSame( dataNode, dataNode.getLeft().getParent());
    }

    @Test
    public void insertTest() {
        oneNode.insert( new Integer(15));
        assertEquals( new Integer(15),
                oneNode.getLeft().getData() );

        oneNode.insert( new Integer(42));
        assertEquals( new Integer(42),
                oneNode.getRight().getData() );

        assertEquals( new Integer(19),
                oneNode.search( new Integer(42)).getParent().getData());

        assertEquals( new Integer(19),
                oneNode.search( new Integer(15)).getParent().getData());
    }

    @Test
    public void searchTest() {
        // TEST BASE CASE
        assertEquals( new Integer(20),
                dataNode.search( new Integer(20)).getData());

        assertEquals( null,
                dataNode.search( new Integer(18)));
    }
}