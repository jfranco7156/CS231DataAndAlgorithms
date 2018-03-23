package project5;
/**
 * File: MyQueue.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class MyQueue<T> implements Iterable<T>{
	//fields
	Node head;//Stores the head of the Node
	Node tail;//Stores the tail of the Node
	int size;//Keep track of the size of the queue
	
	public MyQueue() {
		head = null;//Sets head to null
		tail = null;//Sets tail to null
		size = 0;//Sets the size to 0
	}
	
	public int size() {
		return size;
	}
	
	//Inserts the item into the end of the list 
	public boolean offer(T item) {
		Node n = new Node(item);//Creates a Node using item
		if(head==null) {
			head = n;//Sets the head to n
			tail = head;//Sets the tail to head
			size++;//Increments the size by 1
			return true;//returns true
		}
		
		tail.setNext(n);//Sets the next Node of tail to be n
		n.setPrev(tail);//Sets the previous Node of n to be tail
		tail = tail.getNext();//Sets tail to be n
		size++;//Increments the size by 1
		return true;//returns true
	}
	
	//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	public T poll() {
		if(head==null) return null;//Return null if head is empty
		T item = head.getThing();
		if(head.getNext()==null) {
			size--;
			return item;
		}
		head = head.getNext();
		head.setPrev(null);
		size--;
		return item;
	}
	
	//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	public T peek() {
		if(head==null) return null;//head is empty, returns null
		return head.getThing();//returns the item in head
	}
	
	//Returns the type at the specified index parameter
	public T get(int index) {
		if(index<0 || index>=size)return null;
		
		Node n = head;
		for(int i =0; i<index; i++) {
			n = n.getNext();
		}
		
		return n.getThing();
	}

	// Return a new LLIterator pointing to the head of the list
	public Iterator<T> iterator() {
	    return new LLIterator( this.head );
	}
	
	//Returns the data of the Nodes in an ArrayList according to its order
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<T>();//Initializes the ArrayList to store the item in the Node
		Node t = head;//Creates a Node t to go through beginning with the head
		
		while(t!= null) {
			list.add(t.getThing());//Adds the item in Node to the ArrayList
			t = t.getNext();//Sets the Node t to the next Node
		}
		
		return list;//Returns the ArrayList
	}
	
	//Returns the data of the Nodes in an ArrayList in a randomized order
	public ArrayList<T> toShuffledList() {
		ArrayList<T> list = toArrayList();//Stores the Nodes in order in an ArrayList
		Collections.shuffle(list);//Shuffles the ArrayList
		return list;//Returns the shuffled ArrayList
	}
	
	//inner class Node
	private class Node{
		private Node prev;//Stores the previous Node
		private Node next;//Stores the next Node
		private T item;//item stores the data of the Nodes
		
		//Constructor of Node
		public Node(T item) {
			next = null;
			prev = null;
			this.item = item;
		}
		
		//returns the item field
		public T getThing() {
			return item;
		}
		
		//Sets the next field to the Node n
		public void setNext(Node n) {
			next = n;
		}
		
		//returns the next Node field
		public Node getNext() {
			return next;
		}
		
		//Sets the prev field to the Node n
		public void setPrev(Node n) {
			prev = n;
		}
		
		//Returns the prev Node field
		@SuppressWarnings("unused")
		public Node getPrev() {
			return prev;
		}
	}
	
	//private class LLIterator
	private class LLIterator implements Iterator<T>{
		Node next;
		
		public LLIterator(Node head) {
			this.next = head;
		}
		
		//return boolean value to check whether there is a next value
		public boolean hasNext() {
			return next!=null;
		}
		//returns the next item in the list and sets the next field to the next Node
		public T next() {
			T item = next.getThing();
			next = next.getNext();
			return item;
		}
		
		//Optional function
		public void remove() {
			
		}
	}
	
	public static void main(String[] args) {
		MyQueue<Agent> q = new MyQueue<Agent>();
		q.offer(new Agent(0,0));
		q.offer(new Agent(100,100));
		q.offer(new Agent(200,200));
		q.offer(new Agent(300,300));
	}

}
