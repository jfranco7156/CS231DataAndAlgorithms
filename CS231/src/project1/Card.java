package project1;
/** 
* File: Card.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.util.Random;

public class Card {
	private int value;
	
	public Card() {
		Random rand = new Random();
		value = rand.nextInt(10)+1;
	}
	
	public Card(int v) {
		if(v>0 && v<=10) {
			value = v;
		}
		else {
			System.out.println("Value of card must be and integer between 1 and 10");
		}
	}
	
	public static void main(String[] args) {
		Card c = new Card();
		Card v = new Card(10);
		System.out.println(""+c.getValue());
		System.out.println(""+v.getValue());
	}
	
	public int getValue() {
		return value;	
	}
}
