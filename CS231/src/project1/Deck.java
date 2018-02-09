package project1;

import java.util.ArrayList;

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
	
	public void shuffle() {
		
	}
}
