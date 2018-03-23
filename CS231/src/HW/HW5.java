package HW;

/**
 * CS 231 HW5
 * Email yingli@colby.edu with your answers and questions regarding the homework
 * if you have any. Please set the email subject in the format of 
 * CS231 Spring2018 HW5 -- Your Name
 *
 * Submit by Thursday (03/15/2018) 10:00 pm if you want a response.
 *
 * Grading is 1 if you submit a reasonable attempt, 0 if you don't.
 * 
 * The code compiles and runs. Use it to help you answer questions. 
 */

public class HW5 {
	private int[] queue;
	private int front;
	private int rear;
	private int count;

	public HW5 (int capacity) {
		queue = new int[capacity];
		front = 0;
		rear = 0;
		count = 0;
	}

	// append the new item to the rear of the queue, expanding
	// the capacity of the queue array if necessary.
	public void enqueue (int item) {
		if (size() == queue.length) {
			int[] q = new int[size()*2];
			for(int i=0; i<size();i++) {
				q[i] = queue[front];
				front = (front+1)%queue.length;
			}
			q[count] = item;
			queue = q;
			rear = count+1;
			front = 0;
		}
		else {
			queue[rear] = item;
			rear = (rear + 1)%queue.length;
		}
		count++;
	}
	
	// return the value at the given index
	public Integer get (int index) {
		if(index<0 || index>=size()) return null;
		return queue[(front+index)%queue.length];
	}

	public Integer dequeue () {
		if (isEmpty()) return null;
		int i = queue[front];
		front = (front + 1)%queue.length;
		count--;
		return i;
	}

	public Integer peek () {
		if (isEmpty()) return null;
		return queue[front];
	}

	public int size () {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public static void main (String[] args) {
		HW5 q = new HW5(5);
		for (int i = 0; i < 5; i++) {
			q.enqueue(i);
		}
		System.out.println("After enqueue 5 elements, the size is: " + q.size());
	
		System.out.println("The first element in the queue is: " + q.peek());
	
		for (int i = 0; i < 3; i++) {
			System.out.println(q.dequeue());
		}
		System.out.println("After dequeue 3 elements, the size is: " + q.size());
	
		System.out.println("The first element in the queue is: " + q.peek());
		for (int i = 0; i < 10; i++) {
			q.enqueue(i);
		}
		System.out.println("After enqueue 10 more elements, the size is: " + q.size());
	
		for (int i = 0; i < q.size(); i++) {
			System.out.println(q.get(i));
		}
	}
}