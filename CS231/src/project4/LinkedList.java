package project4;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> implements Iterable<T>{
	//fields
	Node head;
	int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(T item) {
		Node temp = new Node(item);
		if(head != null) temp.setNext(head);
		head = temp;
		size++;
	}
	
	public void addLast(T item) {
		Node temp = new Node(item);
		if(head.getThing().equals(null)) {
			head = temp;
			size++;
			return;
		}
		Node track = head;
		while(head.getNext() !=null) {
			track = track.getNext();
		}
		track.setNext(temp);
	}
	
	public void add(int index, T item) {
		Node temp = new Node(item);
		if(index>size) {
			addLast(item);
			return;
		}
		int i = 0;
		Node t = head;
		while(t!=null) {
			if(i==index-1) {
				Node next = t.getNext();
				t.setNext(temp);
				temp.setNext(next);
			}
			t = t.getNext();
			i++;
		}
	}
	
	//removes the item at the specified position in the list and returns the item removed
	public T remove(int index) {
		T item = null;
		if(index>size) {
			return null;
		}
		Node t = head;
		int i = 0;
		while(t!=null) {
			if(i==index-1) {
				item = t.getNext().getThing();
				t.setNext(t.getNext().getNext());
				return item;
			}
			t = t.getNext();
			i++;
		}
		return item;
	}
	
	// Return a new LLIterator pointing to the head of the list
	public Iterator<T> iterator() {
	    return new LLIterator( this.head );
	}
	
	//inner class node
	private class Node{
		Node next;
		T item;
		
		public Node(T item) {
			next = null;
			this.item = item;
		}
		
		public T getThing() {
			return item;
		}
		
		public void setNext(Node n) {
			next = n;
		}
		
		public Node getNext() {
			return next;
		}
	}
	
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
		// TODO Auto-generated method stub

	}

}
