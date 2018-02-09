package project1;

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
		return "The hand is "+cards;
	}
}
