Regina Ye
PSA 2

I discovered that my insertPrev method was not working, the test would either fail or stuck in a loop that causes the program unable to terminate. So I put a break point at the assertEqual line in the test method, and went into debug mode, saw that my head actually had "prev" that points to itself, so the head was in a perpetual loop that won't end. I decided to step into the line, and saw that the bug pointed towards the second insertPrev condition, which was when there was already two nodes in the list, and the new node is supposed to be the head. So I first drew the memory model, and realized that although the lines of node inside the methods were correct independently, the order was wrong. The wrong order resulted in the confused as to what is the next node to the current node. 


********* Previous Code ******

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

******** End of Previous Code ******

I failed to notice the bug last week because in my junit test I only tested individual nodes, and it never occurred to me that the head could also have a previous! This week instead of testing each nodes, I just printed the list in both directions, and that was when the lists stuck in the loops and failed the test. 

There was not a testing bug 2, but I also missed a few tests last week, so this week I added the deleteLast test, and deletePrev test.

PSA2: 4.5 hours total
3 hours fixing the bugs 
1 hour  reading the assignment and add comments 
0.5 hour writing the report 