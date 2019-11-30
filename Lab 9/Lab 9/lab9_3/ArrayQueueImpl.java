package lab9_3;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = 0;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	public void enqueue(int k) {
		if(size<arr.length) {
			arr[rear] = k;
			rear++;
			size++;
		}else {
			resize();
			arr[rear] = k;
			rear++;
			size++;
		}
		
	}
	public void dequeue() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
			peek();
			arr[front]=0;
			front++;
			size--;
	}
	public int peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[front];
	}
	public void resize() {
		int[]newArray = new int[arr.length * 2];
		System.arraycopy(arr, 0, newArray, 0, arr.length);
		arr = newArray;
		System.out.println("Resizing...");
	}
	 //isEmpty, size, enqueue, dequeue, and peek. 
	
	
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		//uncomment when ready
		for(int i = 0; i < 15; i ++)
		q.enqueue(i);
	for(int i = 0; i < 14; i ++)
		q.dequeue();
	System.out.println(q.size());
	System.out.println(q.peek());
	}
}

