import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for doubly linked list
 * 
 * @author ReginaYe
 *
 */
public class DoublyLinkedListTest {
	
	/**
	 * the initial linked list 
	 */

	@Test
	public void testIsEmpty(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("a");
		assertFalse(list.isEmpty());
	}	

	
	@Test
	public void testInsertFirst(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("a");
		list.insertFirst("b");
		assertEquals("b", list.getFirstNode().getData());
	}
	
	@Test
	public void testGetSize(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals(3, list.getSize());
	}
	@Test 
	public void testInsertAfter(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("a");
		list.insertAfter(list.getFirstNode(), "b");
		assertEquals("b", list.getFirstNode().getNext().getData());
	}
	
	@Test
	public void testDeletePrev(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		list.deletePrev(list.tail);
		assertEquals("a", list.tail.getPrev().getData());
	}
	
	@Test
	public void testDeleteNext(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("b");
		list.insertFirst("a");
		list.deleteNext(list.getFirstNode());
		assertEquals(null, list.getFirstNode().getNext());
	}
	
	@Test
	public void testDeleteLast(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("b");
		list.insertFirst("a");
		list.deleteLast();
		assertEquals("a", list.getLastNode().getData());
	}
	
	
	@Test
	public void testToString(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals("abc", list.toString());
	}
	
	@Test
	public void testToStringPrev(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals("cba", list.toStringPrev());
	}
	
	
}
