package project1;

/**
 * File: Deck.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	ArrayList<Card> deck;
	
	public Deck() {
		build();
	}
	
	public void build() {
		for(int i=1; i<10; i++) {
			for(int j=0; j<4; j++) {
				deck.add(new Card(i));
			}
		}
		for(int k=0; k<16; k++) {
			deck.add(new Card(10));
		}
	}
	
	public Card deal() {
		return deck.remove(0);
	}
	
	public Card pick(int i) {
		return deck.remove(i);
	}
	
	public void shuffle() {
		ArrayList<Card> d = new ArrayList<Card>();
		for(int i=0;i<deck.size();i++) {
			d.add(deck.get(i));
		}
		Random rand = new Random();
		int n = deck.size()-1;
		while(n>0) {
			int r = rand.nextInt(n);
			deck.set(n, d.get(r));
			d.remove(r);
			n--;
		}
	}
	
	public String toString() {
		String s = "";
		for(Card c:deck) {
			s = s + c.getValue() + ", ";
		}
		return "The deck contains"+ s;
	}
}
