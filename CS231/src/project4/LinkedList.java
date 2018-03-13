package project4;
/**
 * File: LinkedList.java
 * Author: Jenniber Franco
 * Date: 03/12/2018
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> implements Iterable<T>{
	//fields
	Node head;//Stores the head node
	int size;//Stores the size of the list
	
	public LinkedList() {
		head = null;//Initializes the head to a null
		size = 0;//Sets the size to 0
	}
	
	//clears the LinkedList
	public void clear() {
		head = null;//Resets the head to null
		size = 0;//Sets the size 0
	}
	
	public int size() {
		return size;//Returns the size field
	}
	
	//Creates the item to a Node and adds to the beginning of the list
	public void addFirst(T item) {
		Node temp = new Node(item);//Creates a temp Node using item
		if(head != null) temp.setNext(head);//If the head is not null, sets the next field in temp Node to be the head
		head = temp;//Sets the head to be temp
		size++;//Increments the size by 1
	}
	
	//Creates the item to a Node and adds to the end of the list
	public void addLast(T item) {
		Node temp = new Node(item);//Creates a temp Node using item
		
		if(head==null) {//if the head is null
			head = temp;//Sets the head to be temp
			size++;//Increments the size by 1
			return;//returns to exit out of the method
		}
		Node track = head;//Sets the tracked Node to head
		while(track != null) {//if track is not null
			if(track.getNext()==null)break;//if there is no next Node from track, it will break from the while loop
			track = track.getNext();//Sets the track Node to the next Node
		}
		track.setNext(temp);//Sets the next Node of track to be temp
		size++;//Increments the size by 1
	}
	
	//Creates the item to a Node and adds to the index position of the list
	public void add(int index, T item) {
		Node temp = new Node(item);//Creates a temp Node using item
		if(index>size) {//if index is greater than size
			addLast(item);//Calls addLast method
			return;//returns to exit method
		}
		int i = 0;//Sets integer i to 0
		Node t = head;//Sets the Node to the head
		if(index==0) {//if the index is equal to 0
			addFirst(item);//Calls the addFirst method()
			return;//returns to exit the method
		}
		while(t!=null) {
			if(i==index-1) {//if i is less than index-1
				Node next = t.getNext();//Sets the next Node to the next Node in t
				t.setNext(temp);//Sets the next Node in t to temp
				temp.setNext(next);//Sets the next Node in temp to next
				size++;//Increments the size by 1
				break;//breaks the while loop
			}
			t = t.getNext();//Sets t to the next Node in t
			i++;//Increments i by 1
		}
	}
	
	//Removes the item at the specified position in the list and returns the item removed
	public T remove(int index) {
		T item = null;//Sets the item to null
		if(index>size) {//if index is greater than size
			return null;//returns null
		}
		
		Node t = head;//Node t is equal to head
		int i = 0;//integer is equal to 0
		
		while(t!=null) {
			if(index==0) {//if index is equal to 0
				item = t.getThing();//item is set to the heads item
				head = t.getNext();//head is set to the next Node in t
				size--;//size is reduced by 1
				break;//breaks from the while loop
			}
			else if(i==index-1) {//if i is equal to index-1
				item = t.getNext().getThing();//Sets item to t's next Node item
				t.setNext(t.getNext().getNext());//Sets t's next Node to t's next next Node
				size--;//size is reduced by 1
				break;//breaks from the while loop
			}
			t = t.getNext();//Sets t to the next Node
			i++;//Increments i by 1
		}
		return item;//returns item
	}
	
	// Return a new LLIterator pointing to the head of the list
	public Iterator<T> iterator() {
	    return new LLIterator( this.head );//Returns a new LLIterator using the head
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
	
	//inner class node
	private class Node{
		private Node next;//Stores the next Node
		private T item;//Stores the item T
		
		public Node(T item) {
			next = null;//Sets next to null
			this.item = item;//Sets the item field to the item parameter
		}
		
		public T getThing() {
			return item;//Returns the item field
		}
		
		public void setNext(Node n) {
			next = n;//Sets the next field to n
		}
		
		public Node getNext() {
			return next;//Returns the next field
		}
	}
	
	//inner class LLIterator
	private class LLIterator implements Iterator<T>{
		Node next;//Stores the next Node
		
		public LLIterator(Node head) {
			this.next = head;//Sets the next Node to the head
		}
		
		
		public boolean hasNext() {
			return next!=null;//Returns a boolean value to check whether there is a next value
		}
		
		//Returns the next item in the list and sets the next field to the next Node
		public T next() {
			T item = next.getThing();//Stores the item of next in a variable item
			next = next.getNext();//Sets next field to the next Node of the next field
			return item;//Returns item
		}
		
		//Optional function
		public void remove() {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
