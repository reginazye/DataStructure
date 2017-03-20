public class PriorityQueueBH<T> implements PriorityQueue<T> {

	protected BinaryHeap pqHeap;

	public PriorityQueueBH(BinaryHeap emptyBH) {
		// TODO Auto-generated constructor stub
		pqHeap = emptyBH;
	}

	public PriorityQueueBH(int size) {
		pqHeap = new BinaryHeapA(size);
	}

	@Override
	public void insert(Comparable value) {
		this.pqHeap.addElement(value);
		increase_value(pqHeap.size(), value);

	}

	@Override
	public Comparable maximum() {
		return pqHeap.getElement(1);
	}

	@Override
	public Comparable extract_max() {
		if (pqHeap.size() < 1) {
			System.out.print("error");
			return null;
		}
		Comparable max = pqHeap.getElement(1);
		pqHeap.swap(1, pqHeap.size());
		pqHeap.setSize(pqHeap.size() - 1);
		pqHeap.maxHeapify(1);
		pqHeap.buildMaxHeap();
		return max;
	}

	@Override
	public void increase_value(int heapIndex, Comparable newValue) {
		((BinaryHeapA) pqHeap).setElement(heapIndex, newValue);
		pqHeap.maxHeapify(1);
	}
}
