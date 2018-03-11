package HW;

import java.util.EmptyStackException;

/**
 * CS 231 HW4
 * Email yingli@colby.edu with your answers and questions regarding the homework
 * if you have any. Please set the email subject in the format of 
 * CS231 Spring2018 HW4 -- Your Name
 *
 * Submit by Thursday (03/09/2018) 10:00 pm if you want a response.
 *
 * Grading is 1 if you submit a reasonable attempt, 0 if you don't.
 * 
 * The code compiles and runs. Use it to help you answer questions. 
 */

public class HW4<T> extends Stacky<T> {
	private class Node {
		private T data;
		private Node next;
	
		public Node (T data, Node n) {this.data = data; next = n;}
	
		public Node getNext () {return next;}
		public void setNext (Node n) {next = n;}
		public T getData () {return data;}
		public void setData (T data) {this.data = data;}
	}

	private Node top;

	public HW4 () {top = null;}

	public String toString () {
		String s = "";
		Node tmp = top;
		while (tmp != null) {
			s += tmp.getData() + " ";
			tmp = tmp.getNext();
		}
		return s;
	}

	public static void main (String[] args) {
		HW4<Integer> mystack = new HW4<Integer>();
		for (int i = 0; i < 5; i++) {
			mystack.push(i);
		}
		System.out.println(mystack);
		System.out.println("*** Test Search 1 ***");
		System.out.println("indexOf(0): " + mystack.indexOf(0));
		System.out.println("indexOf(3): " + mystack.indexOf(3));
		System.out.println("indexOf(5): " + mystack.indexOf(5));
		mystack.pop();
		mystack.pop();
		System.out.println("*** Test Search 2 ***");
		System.out.println("indexOf(0): " + mystack.indexOf(0));
		System.out.println("indexOf(3): " + mystack.indexOf(3));
		System.out.println("indexOf(5): " + mystack.indexOf(5));
	}

	@Override
	public void push(T data) {
		Node n = new Node(data,top);
		top = n;
		size++;
		
	}

	@Override
	public T pop() {
		T data = null;
		if(isEmpty()) throw new EmptyStackException();
		else {
			data = top.getData();
			top = top.getNext();
			size--;
		}
		return data;
	}

	@Override
	public int indexOf(Object o) {
		int i = 0;
		Node n = top;
		while(n!= null) {
			if(n.getData().equals(o)) return i;
			i++;
			n = n.getNext();
		}
		return -1;
	}
}

abstract class Stacky <T> {
	protected int size;

	public Stacky () {
		size = 0;
	}

	public boolean isEmpty () {
		return size == 0;
	}

	public int size () {
		return size;
	}

	public abstract void push (T data);
	public abstract T pop ();
	/* indexOf method
	 * returns the index of the first occurrence of the 
	 * specified element in this list, or -1 if this list 
	 * does not contain the element.
	 */	
	public abstract int indexOf (Object o);
}