package project7;

/**
 * File: KeyValuePair.java
 * Author: Jenniber Franco
 * Date: 04/09/2018
 */
public class KeyValuePair<K, V> {
	K key;
	V value;
	
	public KeyValuePair(K k, V v) {
		key = k;
		value = v;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V v) {
		value = v;
	}
	
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
	
}
