package project1;
/**
 * File: Hand.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;//field to store the information of cards that are currently in the hand
	
	public Hand() {
		cards = new ArrayList<Card>();//initiliazes the ArrayList to hold cards
	}
	
	public void reset() {
		cards.clear();//resets the card ArrayList to have no card items
	}
	
	public void add(Card card) {
		cards.add(card);//adds a card to the ArrayList
	}
	
	public int size() {
		return cards.size();//returns the total amount of cards that are in the card ArrayList
		
	}
	
	public Card getCard(int i) {
		return cards.get(i);//returns a card from the ArrayList at the specific index given as a parameter
	}
	
	public int getTotalValue() {
		int sum=0;//initializes the integer variable 'sum' to 0
		for(int i=0;i<size();i++) {//loops through the Array List of cards
			sum+=getCard(i).getValue();//adds the value of the card to the sum
		}
		return sum;//returns the total value of the cards in the Array List
	}
	
	public String toString() {
		String s = "";//initializes the String s to an empty String
		for(int i=0; i<size(); i++) {//loops through the Array List of cards
			if(i!=size()-1) {//checks if the integer i is not the last value in the Array List in cards
				s += getCard(i).getValue()+", ";//Concatenates the value of a card and ", " to the String s
			}
			else {
				s += getCard(i).getValue();//Only concatenates the value of the last card in the Array List cards
			}
		}
		return s;//Returns the String s
	}
}
