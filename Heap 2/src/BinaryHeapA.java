import java.util.Arrays;

/**
 * Regina Ye
 * 
 * second version of the test
 * 
 */
public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T> {
    // array to hold the heap
    private Comparable[] internalArray;
    // keep track of the heap size (different from the capacity)
    private int heapSize;
    
    public BinaryHeapA(int num){
    	heapSize=0;
    	internalArray = new Comparable[num];
    }

    public BinaryHeapA(Comparable[] array){
    	internalArray = array;
    	heapSize = array.length;
    	buildMaxHeap();
    }

	public T getElement(int idx) {
		return (T) internalArray[idx-1];
	}

	public void addElement(Comparable e) {
		if (heapSize < capacity()) {
			heapSize++;
			internalArray[heapSize-1] = e;
			buildMaxHeap();
		}
	}

	/**
	 * to get the left child index 
	 * @param idx
	 * @return
	 */
	public int leftChild(int idx) {
		return 2*idx;
	}

	/**
	 * to get the right child index 
	 * @param idx
	 * @return
	 */
	public int rightChild(int idx) {
		return 2*idx+1;
	}

	/**
	 * to get the parent index 
	 * @param idx
	 * @return
	 */
	public int parent(int idx) {
		return (int) Math.floor(idx/2);
	}

	/**
	 * get heap capacity
	 */
	public int capacity() {
		return internalArray.length;
	}


	/**
	 * get the heap size
	 */
	public int size() {
		return heapSize;
	}

	/**
	 * swap two elements in the heap 
	 */
	public void swap(int x, int y) {
		Comparable temp = internalArray[x-1];
		internalArray[x-1] = internalArray[y-1];
		internalArray[y-1] = temp;
	}

	/**
	 * set size of the heap 
	 */
	public void setSize(int size) {
		heapSize = size;
	}

	/**
	 * to actually build max heap 
	 */
	public void buildMaxHeap() {
		for (int i =(int)Math.floor(heapSize/2); i>0; i--){
			maxHeapify(i);
		}
	}

	/**
	 * helper method for building the max heap 
	 */
	public void maxHeapify(int idx) {
		int left = leftChild(idx);
		int right = rightChild(idx);
		int max =0; 
		
		if (left<=heapSize && getElement(left).compareTo(getElement(idx))>0) {
			max = left;
		} else {
			max = idx;
		}
		if (right <= heapSize && getElement(right).compareTo(getElement(max))>0) {
			max = right;
		}
		if (max != idx) {
			swap(idx, max);
			maxHeapify(max);
		}
	}

	
	public boolean isEmpty() {
		return heapSize == 0;
	}



    
}
