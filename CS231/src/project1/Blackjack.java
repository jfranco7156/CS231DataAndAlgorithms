package project1;

/**
 * File: Blackjack.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

public class Blackjack {
	private Deck d;
	private Hand playerHand;
	private Hand dealerHand;
	
	public Blackjack() {
		playerHand = new Hand();
		dealerHand = new Hand();
		reset(true);
	}
	
	public void reset(boolean newDeck) {
		if(newDeck) {
			setD(new Deck());
			getD().shuffle();
		}
	}
	
	public void deal() {
		playerHand.reset();
		dealerHand.reset();
		for(int i=0; i<2; i++) {
			playerHand.add(getD().deal());
			dealerHand.add(getD().deal());
		}
	}
	
	public String toString() {
		String s = "The player has "+ playerHand.toString()+".\n";
		s += "The dealer has "+ dealerHand.toString()+".\n";
		s += "These are the cards left in the deck:"+ getD().toString()+".";
		return s;
	}
	
	public boolean playerTurn() {
		while(playerHand.getTotalValue()<16) {
			playerHand.add(getD().deal());
		}
		//System.out.println("The player has cards "+playerHand.toString()+" and it has a total of "+playerHand.getTotalValue());
		if(playerHand.getTotalValue()>21) {
			return false;
		}
		return true;
	}
	
	public boolean dealerTurn() {
		while(dealerHand.getTotalValue()<17) {
			dealerHand.add(getD().deal());
		}
		//System.out.println("The dealer has cards "+dealerHand.toString()+" and it has a total of "+dealerHand.getTotalValue());
		if(dealerHand.getTotalValue()>21) {
			return false;
		}
		return true;		
	}

	public int playRound() {
		deal();
		//System.out.println(toString());
		if (!playerTurn()) {
			return -1;
		}
		else if(!dealerTurn()) {
			return 1;
		}
		else {
			int dealerP = dealerHand.getTotalValue();
			int playerP = playerHand.getTotalValue();
			if(dealerP<playerP) {
				return 1;
			}
			else if(dealerP>playerP) {
				return -1;
			}
			return 0;
		}
	}
	
	public Deck getD() {
		return d;
	}

	public void setD(Deck d) {
		this.d = d;
	}
	
	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		for(int i=0; i<3; i++) {
			if(game.getD().getDeck().size()<20) {
				game.reset(true);
			}
			game.playRound();
		}
	}
}
