package project1;

/**
 * File: Hand.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void reset() {
		cards.clear();
	}
	
	public void add(Card card) {
		cards.add(card);
	}
	
	public int size() {
		return cards.size();
		
	}
	
	public Card getCard(int i) {
		return cards.get(i);
	}
	
	public int getTotalValue() {
		int sum=0;
		for(int i=0;i<cards.size();i++) {
			sum+=cards.get(i).getValue();
		}
		return sum;
	}
	
	public String toString() {
		String s = "";
		for(Card c:cards) {
			s = s + c.getValue() + ", ";
		}
		return "The deck contains"+ s;
		/**
		return "The hand is "+cards;
		*/
	}
}
