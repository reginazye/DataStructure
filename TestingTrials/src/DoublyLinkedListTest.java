import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for doubly linked list
 * 
 * @author ReginaYe
 *
 */
public class DoublyLinkedListTest {
	
	//prepare an empty doubly linked list 
	DoublyLinkedList<String> list = new DoublyLinkedList<String>();

	
	/**
	 * test for is empty method 
	 */
	@Test
	public void testIsEmpty(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertTrue(list.isEmpty());
		list.insertFirst("a");
		assertFalse(list.isEmpty());
	}	

	/**
	 * test for insert first 
	 */
	@Test
	public void testInsertFirst(){
		//list: a
		list.insertFirst("a");
		assertEquals("a", list.getFirstNode().getData());
		//list: b a 
		list.insertFirst("b");
		assertEquals("ba", list.toString());
		assertEquals("ab", list.toStringPrev());
		//list: c b a
		list.insertFirst("c");
		assertEquals("cba", list.toString());
		assertEquals("abc", list.toStringPrev());
	}

	/**
	 * test for get size method 
	 */
	@Test
	public void testGetSize(){
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals(3, list.getSize());
	}
	
	/**
	 * test for insert after 
	 */
	@Test 
	public void testInsertAfter(){
		//list: a,b
		list.insertFirst("a");
		list.insertAfter(list.getFirstNode(), "b");
		assertEquals("b", list.getFirstNode().getNext().getData());
		//list: a, b, c
		list.insertAfter(list.getLastNode(), "c");
		assertEquals("c", list.getLastNode().getData());
		assertEquals("abc", list.toString());
		//list: a,b,x,c
		list.insertAfter(list.getFirstNode().getNext(), "x");
		assertEquals("abxc", list.toString());
		assertEquals("cxba", list.toStringPrev());
	}
	
	/**
	 * test for delete previous method 
	 */
	@Test
	public void testDeletePrev(){
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		list.deletePrev(list.getLastNode());
		assertEquals("ac", list.toString());
		assertEquals("ca", list.toStringPrev());
		list.deletePrev(list.getLastNode());
		assertEquals("c", list.toString());
	}
	
	/**
	 * test for delete next method 
	 */
	@Test
	public void testDeleteNext(){
		//initial list: a,b,c
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		list.deleteNext(list.getFirstNode());
		assertEquals("ac", list.toString());
		assertEquals("ca", list.toStringPrev());
		list.deleteNext(list.getFirstNode());
		assertEquals("a", list.toString());
	}
	
	/**
	 * test for delete last method 
	 */
	@Test
	public void testDeleteLast(){
		//initial list: abc
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		list.deleteLast();
		//now list is ab
		assertEquals("ab", list.toString());
		assertEquals("ba", list.toStringPrev());
		//now list is a
		list.deleteLast();
		assertEquals("a", list.toString());
	}
	
	/**
	 * test for inserting in front of a node 
	 */
	@Test
	public void testInsertPrev(){
		list.insertFirst("a");
		list.insertPrev(list.getFirstNode(), "b");
		assertEquals("ab", list.toStringPrev());
		assertEquals("ba", list.toString());
		list.insertPrev(list.getFirstNode(), "c");
		assertEquals("cba", list.toString());
		assertEquals("abc", list.toStringPrev());
		
	}
	
	/**
	 * test for insert at the end of the list 
	 */
	@Test
	public void testInsertLast(){
		list.insertLast("a");
		list.insertLast("b");
		list.insertLast("c");
		assertEquals("abc", list.toString());
		assertEquals("cba", list.toStringPrev());
	}
	
	/**
	 * test the to string method 
	 */
	@Test
	public void testToString(){
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals("abc", list.toString());
	}
	
	/**
	 * test the reversed to string method 
	 */
	@Test
	public void testToStringPrev(){
		list.insertFirst("c");
		list.insertFirst("b");
		list.insertFirst("a");
		assertEquals("cba", list.toStringPrev());
	}
	
	
}
