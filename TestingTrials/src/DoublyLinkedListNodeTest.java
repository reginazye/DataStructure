import static org.junit.Assert.*;

import org.junit.Test;

/**
 * the test class for the doubly linked list node class
 * 
 * @author ReginaYe
 *
 */
public class DoublyLinkedListNodeTest {
	
	DoublyLinkedListNode<String> node1 = new DoublyLinkedListNode<String>("a");
	DoublyLinkedListNode<String> node2 = new DoublyLinkedListNode<String>("b");
	DoublyLinkedListNode<String> node3 = new DoublyLinkedListNode<String>("c");

	@Test
	public void testGetData() {
		assertEquals("a", node1.getData()); 
	}

	@Test
	public void testSetNext(){
		node1.setNext(node2);
		assertEquals("b", node1.getNext().getData()); 
	}
	
	@Test 
	public void testConstructor(){
		DoublyLinkedListNode<String> node = new DoublyLinkedListNode<String>("hello");
		assertEquals("hello", node.getData());
	}
	
	@Test
	public void testSetData(){
		node1.setData("aaa");
		assertEquals("aaa", node1.getData());
	}
	
	@Test
	public void testGetNext(){
		node1.setNext(node2);
		assertEquals("b", node1.getNext().getData());
	}
	
	@Test
	public void testSetPrev(){
		node3.setPrev(node2);
		assertEquals("c", node2.getNext().getData());
		assertEquals("b", node3.getPrev().getData());
	}
	
	@Test
	public void testGetPrev(){
		node3.setPrev(node2);
		assertEquals("b", node3.getPrev().getData());
	}
	
}
