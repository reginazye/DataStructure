
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by peter on 2/7/17.
 *
 * Warning, these tests are just a jumping off point
 * to help you make sure that your methods have the correct
 * headers.
 *
 */
public class BinaryHeapBasicTests {
    // we use a BinaryHeapA variable here
    // because we want to test the internal
    // methods of the BinaryHeapA, not just
    BinaryHeapA<Integer> emptyBHA;
    BinaryHeapA<Integer> filledBHA;

    @Before
    public void init() {
        emptyBHA = new BinaryHeapA<Integer>(10);
        Integer[] stringArray = {1,10,5,2,6,3,7,9,4,8};
        filledBHA = new BinaryHeapA<Integer>(stringArray);
    }

    @Test
    public void getElementTest() {
        Integer expected = 8;
        assertEquals("getElement  test",expected,filledBHA.getElement(5));
    }

    @Test
    public void addElementTest() {
        emptyBHA.addElement(10);
        assertEquals("addElement test",((Integer)10),emptyBHA.getElement(1));
    }

    @Test
    public void leftChildTest() {
        assertEquals("leftChild test",2,filledBHA.leftChild(1));
    }

    @Test
    public void rightChildTest() {
        assertEquals("empty size test",3,filledBHA.rightChild(1));
    }

    @Test
    public void parentTest() {
        assertEquals("empty size test",2,filledBHA.parent(5));
    }


    @Test
    public void capacityTest() {
        assertEquals("empty size test",10,emptyBHA.capacity());
    }

    @Test
    public void sizeTest() {
        assertEquals("empty size test",0,emptyBHA.size());
    }

    @Test
    public void setSize() {
        filledBHA.setSize(filledBHA.size()-1);
        assertEquals("set size test",9,filledBHA.size());
    }

    @Test
    public void swapTest() {
        Integer expected = 9;
        filledBHA.swap(1,2);
        assertEquals("swap test",expected,filledBHA.getElement(1));
    }

    @Test
    public void buildMaxHeap() {
        Integer expected = 6;
        filledBHA.buildMaxHeap();
        assertEquals("buildMaxHeap test",expected,filledBHA.getElement(10));
    }

    @Test
    public void maxHeapifyTest() {
        Integer expected = 6;
        filledBHA.maxHeapify(10);
        assertEquals("maxHeap test",expected,filledBHA.getElement(10));
    }

    @Test
    public void isEmptyTest() {
        assertEquals("isEmpty Test",true,emptyBHA.isEmpty());
    }

}
