package project1;
/**
 * File: Deck.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> deck;//field to store the Array List of cards that are typically in a deck
	
	public Deck() {
		deck = new ArrayList<Card>();//initializes the field of the Array List of the deck
		build();//calls the function build written below
	}
	
	public void build() {
		for(int i=1; i<10; i++) {//loops through 10 times between values 1 and 9 for i
			for(int j=0; j<4; j++) {//loops through 4 times
				Card c = new Card(i);//Creates a new card and initializes it with value i
				getDeck().add(c);//Adds the newly created card into the Array List deck
			}
		}
		for(int k=0; k<16; k++) {//loops through the Array List 16 times
			getDeck().add(new Card(10));//creates a new card with a value of 10 and adds it to the Array List deck
		}
	}
	
	public Card deal() {
		return getDeck().remove(0);//removes and returns the first item from the Array List of deck
	}
	
	public Card pick(int i) {
		return getDeck().remove(i);//removes and returns the item i from the Array List deck
	}
	
	public void shuffle() {
		ArrayList<Card> d = new ArrayList<Card>();//Initializes an Array List of Card objects
		for(int i=0;i<getDeck().size();i++) {//Loops through the Array List deck
			d.add(getDeck().get(i));//adds the card in deck to d Array List
		}
		Random rand = new Random();//Creates a Random rand
		int n = getDeck().size()-1;//Sets the n variable to size of the deck minus 1
		while(n>0) {//loop that will keep running as long as integer is greater than 0
			int r = rand.nextInt(n);//generates a random integer from 0 and exclusive of n
			getDeck().set(n, d.remove(r));//Sets the Card in index n from deck to the Card removed from index r
			n--;//subtracts 1 from integer n
		}
	}
	
	public String toString() {
		String s = "";//Creates String value s
		for(Card c:getDeck()) {//loops through deck for each Card c
			s = s + c.getValue() + ", ";//Concatenates the String s and the value of the card  with a comma
		}
		return s;//returns the String s
	}

	public ArrayList<Card> getDeck() {
		return deck;//returns the Array List of deck
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;//sets an entire Array List of deck to the field of this class
	}
}
