/**
 * Doubly Linked List Node 
 * 
 * @author ReginaYe
 *
 * @param <T>
 */
public class DoublyLinkedListNode<T> extends LinkedListNode<T>{
	protected DoublyLinkedListNode<T> prev;

	public DoublyLinkedListNode(T data) {
		super(data);
	}
	
	public void setPrev(DoublyLinkedListNode<T> node){
		this.prev = node;
	}

	
	public DoublyLinkedListNode<T> getPrev(){
		return prev;
	}
	
	
	public DoublyLinkedListNode<T> getNext(){
		return (DoublyLinkedListNode<T>) this.next;
	}
}
