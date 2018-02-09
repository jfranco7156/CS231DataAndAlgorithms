package project1;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void reset() {
		this.cards.clear();
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public int size() {
		return this.cards.size();
		
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public int getTotalValue() {
		int sum=0;
		for(int i=0;i<this.cards.size();i++) {
			sum+=cards.get(i).getValue();
		}
		return sum;
	}
	
	public String toString() {
		return "The hand is "+this.cards;
	}
}
