import java.awt.List;

public class DoublyLinkedList<T> extends LinkedList<T>{
	//public DoublyLinkedListNode<T> head;
	public DoublyLinkedListNode<T> tail;
	
	public DoublyLinkedList(){
		super();
	}

	public DoublyLinkedListNode<T> getFirstNode(){
		return (DoublyLinkedListNode<T>) this.head;
	}
	
	public DoublyLinkedListNode<T> getLastNode(){
		return tail;
	}
	
	public boolean isEmpty() {
		if (this.head == null && this.tail==null) {
			return true;
		}
		return false;
	}
	
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
	
	public void insertPrev(DoublyLinkedListNode<T> currentNode, T data){
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (currentNode==head){
			currentNode.prev = added;
			head = added;
			added.setNext(currentNode);
		}
		else if (currentNode.getNext()!=null){	
			currentNode.prev.next = added;
			added.setPrev(currentNode); 	
			added.setNext(currentNode);
			currentNode.setPrev(added);
		}	
	}
	
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data){
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (currentNode == head){
			head.setNext(added);
			added.setPrev((DoublyLinkedListNode<T>) head);
			tail = added;
		}else{
			added.setNext(currentNode.getNext());
			currentNode.setNext(added);
			added.setPrev(currentNode);
			((DoublyLinkedListNode<T>) currentNode.getNext()).setPrev(added);
			
		}
	}
	
	public void deletePrev(DoublyLinkedListNode<T> node){
		if (node.getPrev()==null || node==null) {
			System.out.println("ajkhbc");
			return;
		}
		if(node.getPrev()!=null){
			if (node.prev==head){
				System.out.println("abc");
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
	
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		if (isEmpty()){
			return;
		}
		if (!isEmpty()) {
			if (currentNode.getNext()==tail) {
				currentNode.next=null;
				tail = currentNode;
			}
		else {
			currentNode.setNext(currentNode.getNext().getNext());
			((DoublyLinkedListNode<T>) currentNode.getNext()).setPrev(currentNode);
		}
		}
	}
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
	
	public String toString(){
		DoublyLinkedListNode<T> temp = (DoublyLinkedListNode<T>) head;
		String string = "";
		while (temp!=null){
			string = string + temp.getData();
			temp = (DoublyLinkedListNode<T>) temp.getNext();
		}
		return string;
	}
	
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

