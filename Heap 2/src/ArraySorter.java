/** 
 * ArraySorter provides sorting methods for arrays of Comparables.
 * @author Regina Ye
 **/
public class ArraySorter
{
	/**
	 * Uses selection sort algorithm to sort the array.
	 * Modifies the passed array so that its elements are in ascending, 
	 * sorted order.
	 **/
	public static void selectionSort( Comparable[] array )
	{
		/* you do not need to fill this in for COMSC 211 */
	}
	
	
	/**
	 * Uses insertion sort algorithm to sort the array.
	 * Modifies the passed array so that its elements are in ascending, 
	 * sorted order.
	 **/
	public static void insertionSort( Comparable[] array )
	{
		/* you do not need to fill this in for COMSC 211 */
	}
	
	/**
	 * Uses bubble sort algorithm to sort the array.
	 * Modifies the passed array so that its elements are in ascending, 
	 * sorted order.
	 **/
	public static void bubbleSort( Comparable[] array )
	{
		/* you do not need to fill this in for COMSC 211 */
	}

	
	/**
	 * Uses merge sort algorithm to sort the array.
	 * Modifies the passed array so that its elements are in ascending, 
	 * sorted order.
	 **/
	public static void mergeSort( Comparable[] array )
	{
		/* you do not need to fill this in for COMSC 211 */
	}

	/**
	 * Uses Heapsort algorithm to sort the array.
	 * Modifies the passed array so that its elements are in ascending,
	 * sorted order.
	 */
	public static Comparable[] heapSort( Comparable[] array ) {
		BinaryHeap heap = new BinaryHeapA<>(array);
		heap.buildMaxHeap();

		for (int i = array.length; i > 0; i--) {
			heap.swap(1, i);
			heap.setSize(heap.size() - 1);
			heap.maxHeapify(1);

		}
		return array;

	}
}