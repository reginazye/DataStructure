/**
 * Created by peter on 9/22/16.
 */
public interface BinaryHeap<T extends Comparable<T>> {
	
	public T getElement(int idx);
	
	public void addElement(T element);
	
	public int leftChild(int idx);
	
	public int rightChild(int idx);

	public int parent(int idx);

	public int capacity();
	
	public int size();
	
	public void swap(int x, int y);
	
	public void setSize(int size);
	
	public void buildMaxHeap();
	
	public void maxHeapify(int idx);
	
	public boolean isEmpty();
	
	
	
}
