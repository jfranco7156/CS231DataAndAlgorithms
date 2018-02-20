package project1;
/**
 * File: Blackjack.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

public class Blackjack {
	private Deck d;//Field to have the Deck that both player and dealer will be getting their cards from
	private Hand playerHand;//Field to store the cards that will be with the player
	private Hand dealerHand;//Field to store the cards that will be with the dealer
	
	public Blackjack() {
		playerHand = new Hand();//Initializes the playerHand field
		dealerHand = new Hand();//Initializes the dealerHand field
		reset(true);//Resets the deck
	}
	
	//Resets the deck to create a brand new deck when either beginning a new deck or when the cards are insufficient for the next round
	public void reset(boolean newDeck) {
		if(newDeck) {
			setD(new Deck());//Sets the Array List d to a new Deck
			getD().shuffle();//Shuffles the d Array List
		}
	}
	
	//Begins the game to deal two cards each to both the player and the dealer
	public void deal() {
		playerHand.reset();//Resets the playerHand field
		dealerHand.reset();//Resets the dealerHand field
		for(int i=0; i<2; i++) {//Loops through twice
			playerHand.add(getD().deal());//Adds a card from Array List d to the playerHand
			dealerHand.add(getD().deal());//Adds a card from Array List d to the dealerHand
		}
	}
	
	public String toString() {
		String s = "The player has "+ playerHand.toString()+".\n";//Creates String s and adds the playerHand.toString()
		s += "The dealer has "+ dealerHand.toString()+".\n";//Adds the dealerHand.toString() to String s
		return s;//Returns the String s
	}
	
	public Hand getPlayerHand() {
		return playerHand;//returns the object Hand that is used to represent the player
	}
	
	public Hand getDealerHand() {
		return dealerHand;//return the object Hand that is used to represent the dealer
	}
	
	/**
	 * This method was kept to keep the simulation class running. It essentially keeps hitting until the player receives a
	 *  total value of 16 or higher. If the players total value is greater than 21, the method will return false because 
	 *  the player has 'busted'. Otherwise, it will return true.
	 * @return
	 */
	public boolean playerTurn() {
		while(playerHand.getTotalValue()<16) {
			playerHand.add(getD().deal());
		}
		return playerHand.getTotalValue() <= 21;
	}
	
	//Method created to deal single card dependent on the user inputs
	public boolean playerHit() {
		playerHand.add(getD().deal());
		return playerHand.getTotalValue() <= 21;
	}
	
	/**
	 * This method was kept to keep the simulation class running. It essentially keeps hitting until the dealer receives a
	 *  total value of 17 or higher. If the players total value is greater than 21, the method will return false because 
	 *  the dealer has 'busted'. Otherwise, it will return true.
	 * @return
	 */
	public boolean dealerTurn() {
		while(dealerHand.getTotalValue()<17) {
			dealerHand.add(getD().deal());
		}
		return dealerHand.getTotalValue() <= 21;	
	}

	public int playRound() {
		deal();//Deals the card the player and dealer
		if (!playerTurn()) {
			return -1;//Returns -1 if player busts
		}
		else if(!dealerTurn()) {
			return 1;//Returns 1 if dealer busts
		}
		else {
			int dealerP = dealerHand.getTotalValue();//Gets total value in dealerHand cards
			int playerP = playerHand.getTotalValue();//Gets total value in playerHand cards
			if(dealerP<playerP) {
				return 1;//returns 1 if player wins
			}
			else if(dealerP>playerP) {
				return -1;//returns -1 if dealer wins
			}
			return 0;//returns 0 if its a tie
		}
	}
	
	public Deck getD() {
		return d;//Returns the Deck d
	}

	public void setD(Deck d) {
		this.d = d;//Sets d to Deck d
	}
	
	public static void main(String[] args) {
		Blackjack game = new Blackjack();//Initializes a Blackjack game
		for(int i=0; i<3; i++) {//Loops 3 times to play 3 rounds of Blackjack
			if(game.getD().getDeck().size()<20) {//Checks the size of the deck Array List
				game.reset(true);//Resets the deck to contain 52 cards
			}
			int winner = game.playRound();//Plays a round of Blackjack and returns an integer
			if(winner==1){
				System.out.println("The player has won!\n"+game.toString());//If the winner is integer 1 then the player has won
			}
			else if(winner==-1) {
				System.out.println("The dealer has won!\n"+game.toString());//If the winner is integer -1 then the dealer has won
			}
			else {
				System.out.println("The round has ended in a tie.\n"+game.toString());//Prints whether the round has ended in a tie
			}
		}
	}
}
