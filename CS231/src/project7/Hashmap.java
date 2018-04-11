package project7;

import java.util.ArrayList;
import java.util.Comparator;

import project6.BSTMap;

public class Hashmap<K, V> implements MapSet<K, V> {
	//fields
	private ArrayList<BSTMap<String,Integer>> table;//Stores the map of the tree
	
	public Hashmap( Comparator<K> comp, int initCap ) {
		table = new ArrayList<BSTMap<String,Integer>>();
		for(int i = 0; i < initCap; i++) {
			table.add(new BSTMap<String,Integer>(comp));
		}
		//new BSTMap<String, Integer>(comp)
	}
	
	@Override
	public V put(K key, V value) {
		int hash = key.hashCode();
		int index = hash % table.size;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KeyValuePair<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
