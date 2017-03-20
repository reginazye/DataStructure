import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for doubly linked list
 * 
 * @author ReginaYe
 *
 */
public class DoublyLinkedListTestTest {
	
	DoublyLinkedList<String> testList1;
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * the initial linked list 
	 */
	@Before 
	public void TestList1(){
		testList1 = new DoublyLinkedList<String>();
		testList1.insertFirst("c");
		testList1.insertFirst("b");
		testList1.insertFirst("a");
		System.out.println(testList1.getSize());
	}

	@Test
	public void testIsEmpty(){
		assertFalse(testList1.isEmpty());
	}	

	
	@Test
	public void testInsertFirst(){
		testList1.insertFirst("d");
		assertEquals("d", testList1.getFirstNode().getData());
	}
	
	@Test 
	public void testInsertAfter(){
		testList1.insertAfter(testList1.head, "e");
		assertEquals("e", testList1.getFirstNode().next.getData());
	}
	
	@Test
	public void testInsertLast(){
		testList1.insertLast("x");
		assertEquals("x", testList1.tail.getData());
	}
	
	@Test
	public void testInsertPrev(){
		testList1.insertPrev((DoublyLinkedListNode<String>) testList1.head, "y");
		assertEquals("y", testList1.head.getData());
	}
	
	@Test
	public void testDeletePrev(){
		testList1.deletePrev((DoublyLinkedListNode<String>) testList1.head);
		assertEquals("a", testList1.head.getData());
	}
	
	@Test
	public void testDeleteNext(){
		testList1.deleteNext(testList1.head);
		assertEquals("c", testList1.head.next.getData());
	}
	
	@Test
	public void testDeleteLast(){
		testList1.deleteLast();
		assertEquals("c", testList1.tail.getData());
		
		System.out.println("kagjf==" +testList1.toString());
	}
	
}
