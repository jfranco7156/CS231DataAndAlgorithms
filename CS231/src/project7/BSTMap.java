package project7;

/*
***Jenniber Franco***

	Template for the BSTMap classes
	Spring 2018
	CS 231 Project 6
*/
import java.util.ArrayList;
import java.util.Comparator;

public class BSTMap<K, V> implements MapSet<K, V> {
	//fields
	private TNode root;//Stores the root of the binary tree
	private Comparator<K> comp;//Comparator object to compare keys
	private int size;//A size field to keep track of the BST

	// constructor: takes in a Comparator object
	public BSTMap( Comparator<K> comp ) {
		root = null;
		this.comp = comp;
		size = 0;
	}

	// Put the key-value pair into the BSTMap
	// Returns the old value or null if a new key was added
	public V put( K key, V value ) {
		if(root == null) {
			root = new TNode(key,value);//if root is empty, a new TNode is created and stored as the root
			size++;
			return null;
		}
		V val = root.put(new TNode(key,value), comp);
		if(val == null) size++;// Increase the size because a new Node was added to the tree
		return val;//calls the root TNodes put method
	}

	// gets the value at the specified key or null
	public V get( K key ) {
		if(root==null) return null;
		return root.get(key, comp);
	}

	// functions in the MapSet interface
	
	//Return true if the map contains a key-value pair with the given key
	public boolean containsKey(K key) {
		return this.get(key)!=null;
	}

	@Override
	public ArrayList<K> keySet() {
		if (root == null) return null;
		ArrayList<KeyValuePair<K, V>> pairs = entrySet();
		ArrayList<K> keys = new ArrayList<K>();
		for(KeyValuePair<K, V> p: pairs) {
			keys.add(p.getKey());
		}
		return keys;
	}

	@Override
	public ArrayList<V> values() {
		if (root == null) return null;
		ArrayList<KeyValuePair<K, V>> pairs = entrySet();
		ArrayList<V> vals = new ArrayList<V>();
		for(KeyValuePair<K, V> p: pairs) {
			vals.add(p.getValue());
		}
		return vals;
	}

	@Override
	public ArrayList<KeyValuePair<K, V>> entrySet() {
		if(root == null) return null;
		return root.entrySet();
	}

	//returns the size of the binary tree
	public int size() {
		return size;
	}

	//clears the binary tree
	public void clear() {
		root = null;
		size = 0;
	}

	public String toStirng() {
		System.out.println("In Order: ");
		this.printInOrder();
		return "";
	}
	
	// You can make this a nested class, doesn't have to be
	private class TNode {
		//fields
		private TNode left;//stores the children in the left of the tree
		private TNode right;//stores the children in the right of the tree
		private KeyValuePair<K, V> pair;////holds the data of the node
			
		// constructor, given a key and a value
		public TNode( K k, V v ) {
			left = null;
			right = null;
			pair = new KeyValuePair<K, V>(k,v);
		}

		// Takes in a TNode and a comparator and inserts the TNode
		// Returns the old value of the node, if replaced, or null
		public V put( TNode node, Comparator<K> comp ) {
			int result = comp.compare(node.pair.getKey(), pair.getKey());
			if(result == 0) {
				V val = this.pair.getValue();
				this.pair.setValue(node.pair.getValue());
				return val;
			}
			else if(result<0) {
				if(left==null) {
					left = node;
					return null;
				}
				else return left.put(node, comp);
			}
			else {
				if(right==null) {
					right = node;
					return null;
				}
				else return right.put(node, comp);
			}
			// implement the binary search tree put
			// insert only if the key doesn't already exist
			// stub code
		}

		// Takes in a key and a comparator
		// Returns the value associated with the key or null
		public V get( K key, Comparator<K> comp ) {
			int result = comp.compare(key, pair.getKey());
			if(result==0) return pair.getValue();
			else if(result<0) {
				if(left==null) return null;
				else return left.get(key, comp);
			}
			else {
				if(right==null) return null;
				else return right.get(key,comp);
			}
		}

		// Remaining methods below, mostly for building ArrayLists
		public ArrayList<KeyValuePair<K, V>> entrySet() {
			ArrayList<KeyValuePair<K, V>> pList = new ArrayList<KeyValuePair<K, V>>();
			pList.add(pair);
			if(left != null) {
				pList.addAll(left.entrySet());
			}
			if(right != null) {
				pList.addAll(right.entrySet());
			}
			return pList;
		}

		public void printPreOrder() {
			System.out.println(pair.getValue()+" ");
			if(left != null) left.printPreOrder();
			if(right != null) right.printPreOrder();
		}
		
		public void printInOrder() {
			if(left != null) left.printInOrder();
			System.out.println(pair.getValue()+" ");
			if(right != null) right.printInOrder();
		}
		
		public void printPostOrder() {
			if(left != null) left.printPostOrder();
			if(right != null) right.printPostOrder();
			System.out.println(pair.getValue()+" ");
		}
	}// end of TNode class
	
	//functions made to test
	public void printPreOrder() {
		if(root == null) System.out.println("The tree is empty");
		else {
			root.printPreOrder();
		}
	}
	
	public void printInOrder() {
		if(root == null) System.out.println("The tree is empty");
		else {
			root.printInOrder();
		}
	}
	
	public void printPostOrder() {
		if(root == null) System.out.println("The tree is empty");
		else {
			root.printPostOrder();
		}
	}	

	// test function
	public static void main( String[] argv ) {
		// create a BSTMap
		BSTMap<String, Integer> bst = new BSTMap<String, Integer>( new StringAscending() );

		bst.put( "twenty", 20 );
		bst.put( "ten", 10 );
		bst.put( "eleven", 11 );
		bst.put( "five", 5 );
		bst.put( "six", 6 );

		//System.out.println( bst.get( "eleven" ) );

		// put more test code here
		bst.printInOrder();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		bst.printPreOrder();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		bst.printPostOrder();
				
	}
}

// comparator class separate
class StringAscending implements Comparator<String> {
	public int compare( String a, String b ) {
		return a.compareTo(b);
	}
}