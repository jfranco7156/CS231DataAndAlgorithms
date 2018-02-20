package project1;
/** 
* File: Card.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.Random;

public class Card {
	private int value;//field to store the value of the Card
	
	public Card() {//Constructor of Card with no parameters
		Random rand = new Random();
		value = rand.nextInt(10)+1;//Generates a random value between 1 and 10 and sets it to the cards field of value
	}
	
	public Card(int v) {//Constructor of card with a parameter
		if(v>0 && v<=10) {//Checks if the card value is between 1 and 10
			value = v;
		}
		else {
			System.out.println("Value of card must be and integer between 1 and 10. Setting card value to 10.");
			value = 10;//Sets the value of the card to 10 if the value is not between 1 and 10
		}
	}
	
	public static void main(String[] args) {
		Card c = new Card();//Initializes a card
		Card v = new Card(10);//Initializes a card with a value of 10
		System.out.println(""+c.getValue());//Prints the value of the Card c to the terminal
		System.out.println(""+v.getValue());//Prints the value of the Card v to the terminal
	}
	
	public int getValue() {
		return value;//returns the value of the card
	}
}
