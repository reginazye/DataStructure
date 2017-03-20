import java.awt.List;

/**
 * doubly linked list class
 * @author ReginaYe
 *
 * @param <T>
 */
public class DoublyLinkedList<T> extends LinkedList<T>{
	public DoublyLinkedListNode<T> tail;
	
	/**
	 * constructor for doubly linked list 
	 */
	public DoublyLinkedList(){
		super();
	}

	/**
	 * get the first node of the list 
	 */
	public DoublyLinkedListNode<T> getFirstNode(){
		return (DoublyLinkedListNode<T>) this.head;
	}
	
	/**
	 * get the last node of the list 
	 */
	public DoublyLinkedListNode<T> getLastNode(){
		return tail;
	}
	
	/**
	 * see if the list is empty
	 */
	public boolean isEmpty() {
		if (this.head == null && this.tail==null) {
			return true;
		}
		return false;
	}

/**
 * insert a node at the beginning of the list  
 */
	public void insertFirst(T data){
		DoublyLinkedListNode<T> temp = new DoublyLinkedListNode<T>(data); 
		if (isEmpty()){
			head = temp;
			tail = temp;
		}
		if(!isEmpty()){
			if (head.getNext()==null){
				temp.setNext(head);
				((DoublyLinkedListNode<T>) head).setPrev(temp);
				tail = (DoublyLinkedListNode<T>) head;
				head = temp;
				tail.setNext(null);
			}else{
				((DoublyLinkedListNode<T>) head).setPrev(temp);
				temp.setNext(head);
				head = temp;
			}
		
		}
	}
	
	/**
	 * insert a node at the end of the list
	 */
	public void insertLast(T data) {
		LinkedListNode<T> last = getLastNode();
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (last!=null) {
		last.setNext(added);
		added.setPrev((DoublyLinkedListNode<T>) last);
		tail = added;
		}
		if (last == null){
			tail = added;
			head = added;
		}
	}

	/**
	 * insert a node in front of another node 
	 * 
	 * @param currentNode
	 * @param data
	 */
	public void insertPrev(DoublyLinkedListNode<T> currentNode, T data){
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (currentNode == tail && currentNode == head){
			head = added; 
			head.setNext(tail);
			tail.setPrev((DoublyLinkedListNode<T>) head);
		}else if (currentNode == head && currentNode!=tail){
			head = added;
			head.setNext(currentNode);
			currentNode.setPrev((DoublyLinkedListNode<T>) head);
			((DoublyLinkedListNode<T>) head).setPrev(null);
		}else if (currentNode!=head && currentNode!=tail){
			added.setNext(currentNode);
			currentNode.getPrev().setNext(added);
			added.setPrev(currentNode.getPrev());
			currentNode.setPrev(added);
		}	
	}

	/**
	 * insert after a certain node 
	 * @param currentNode
	 * @param data
	 */
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data){
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (currentNode == head){
			head.setNext(added);
			added.setPrev((DoublyLinkedListNode<T>) head);
			((DoublyLinkedListNode<T>) head).setPrev(null);
			if (currentNode == tail) {
				tail = added;
			}
		}else if (currentNode == tail){
			tail = added;
			tail.setPrev(currentNode);
			currentNode.setNext(tail);	
			tail.setNext(null);
		}else if (currentNode!=head && currentNode!=tail){
			added.setNext(currentNode.getNext());
			currentNode.setNext(added);
			added.setPrev(currentNode);
			added.getNext().setPrev(added);
		}
	}

	/**
	 * to delete a node before a certain node 
	 * @param node
	 */
	public void deletePrev(DoublyLinkedListNode<T> node){
		if (node.getPrev()==null || node==null) {
			return;
		}
		if(node.getPrev()!=null){
			if (node.prev==head){
			node.setPrev(null);
			head = node;
			tail = node;
			}else{
				DoublyLinkedListNode<T> temp = node.getPrev().getPrev();
				node.setPrev(temp);
				temp.setNext(node);
			}
		}
	}

	/**
	 * to delete the node before a certain node 
	 * @param currentNode
	 */
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		if (currentNode.getNext()==tail) {
				currentNode.next=null;
				tail = currentNode;
			}
		else{
			currentNode.setNext(currentNode.getNext().getNext());
			((DoublyLinkedListNode<T>) currentNode.getNext()).setPrev(currentNode);
		}
	}
	
	/**
	 * delete the node at the end of the list 
	 */
	public void deleteLast(){
		if (isEmpty()){
			return;
		}
		else if (!isEmpty()){
			if (getSize()==1){
			head = null;
			tail = null;
			}else  {
			DoublyLinkedListNode<T> node = (DoublyLinkedListNode<T>) getLastNode();
			tail=((DoublyLinkedListNode<T>) getLastNode()).getPrev();
			node = null;
			tail.setNext(null);
			}
		}
	}
	
	/**
	 * to convert the whole list to string 
	 */
	public String toString(){
		DoublyLinkedListNode<T> temp = (DoublyLinkedListNode<T>) head;
		String string = "";
		while (temp!=null){
			string = string + temp.getData();
			temp = (DoublyLinkedListNode<T>) temp.getNext();
		}
		return string;
	}
	
	/**
	 * to convert the whole list to string but backwards 
	 * @return string backwards 
	 */
	public String toStringPrev(){
		DoublyLinkedListNode<T> temp = (DoublyLinkedListNode<T>) tail;
		String string = "";
		while (temp!=null){
			string = string + temp.getData();
			temp = (DoublyLinkedListNode<T>) temp.getPrev();
		}
		return string;
	}
	
}

