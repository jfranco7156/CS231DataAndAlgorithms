package project1;

/**
 * File: Deck.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		build();
	}
	
	public void build() {
		for(int i=1; i<10; i++) {
			for(int j=0; j<4; j++) {
				Card c = new Card(i);
				//System.out.println(c.getValue());
				getDeck().add(c);
			}
		}
		for(int k=0; k<16; k++) {
			getDeck().add(new Card(10));
		}
	}
	
	public Card deal() {
		return getDeck().remove(0);
	}
	
	public Card pick(int i) {
		return getDeck().remove(i);
	}
	
	public void shuffle() {
		ArrayList<Card> d = new ArrayList<Card>();
		for(int i=0;i<getDeck().size();i++) {
			d.add(getDeck().get(i));
		}
		Random rand = new Random();
		int n = getDeck().size()-1;
		while(n>0) {
			int r = rand.nextInt(n);
			getDeck().set(n, d.get(r));
			d.remove(r);
			n--;
		}
	}
	
	public String toString() {
		String s = "";
		for(Card c:getDeck()) {
			s = s + c.getValue() + ", ";
		}
		return s;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
}
