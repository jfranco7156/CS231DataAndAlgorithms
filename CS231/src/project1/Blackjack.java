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
		return s;
	}
	
	/**
	 * This method was kept to keep the simulation class running. It essentially keeps hitting until the player receives a
	 *  total value of 16 or higher. If the players total value is less than 21, the method will return false because 
	 *  the player has not 'busted'. Otherwise, it will return true.
	 * @return
	 */
	public boolean playerTurn() {
		while(playerHand.getTotalValue()<16) {
			playerHand.add(getD().deal());
		}
		if(playerHand.getTotalValue()>21) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method was kept to keep the simulation class running. It essentially keeps hitting until the dealer receives a
	 *  total value of 17 or higher. If the players total value is less than 21, the method will return false because 
	 *  the dealer has not 'busted'. Otherwise, it will return true.
	 * @return
	 */
	public boolean dealerTurn() {
		while(dealerHand.getTotalValue()<17) {
			dealerHand.add(getD().deal());
		}
		//System.out.println("The dealer has cards "+dealerHand.toString()+" and it has a total of "+dealerHand.getTotalValue());
		return dealerHand.getTotalValue() <= 21;
/*
		if(dealerHand.getTotalValue()>21) {
			return false;
		}
		return true;*/		
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
			int winner = game.playRound();
			if(winner==1){
				System.out.println("The player has won!\n"+game.toString());
			}
			else if(winner==-1) {
				System.out.println("The dealer has won!\n"+game.toString());
			}
			else {
				System.out.println("The round has ended in a tie.\n"+game.toString());
			}
		}
	}
}
