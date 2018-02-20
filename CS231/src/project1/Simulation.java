package project1;
/**
 * File: Simulation.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.text.DecimalFormat;

public class Simulation {

	public static void main(String[] args) {
		int playerWins = 0;//Creates the integer to keep track the amount the player wins
		int dealerWins = 0;//Creates the integer to keep track the amount the dealer wins
		int ties = 0;//Creates the integer to keep track the amount of ties between the dealer and the player
		Blackjack game = new Blackjack();//Initializes the game of Blackjack 
		for(int i=0; i<1000; i++) {//Loop that runs 1000 times
			if(game.getD().getDeck().size()<20) {//Checks the size of the deck Array List
				game.reset(true);//Resets the deck to contain 52 cards
			}
			int winner = game.playRound();//Plays a round of Blackjack and returns an integer
			if(winner==-1) {//If the winner is integer -1 then the dealer has won
				dealerWins++;//Adds one to the number the dealer has won
			}
			else if(winner==1) {//If the winner is integer 1 then the player has won
				playerWins++;//Adds one to the number the player has won
			}
			else {
				ties++;//Adds one to the number the ties has won
			}
		}
		DecimalFormat df = new DecimalFormat("#.#");
		double playerW = (double) playerWins;//Sets the integer number the player has won to double
		double dealerW = (double) dealerWins;//Sets the integer number the dealer has won to double
		double pushes = (double) ties;//Sets the integer number of ties to double
		System.out.println("The player has won " + playerWins+" times. A percentage of "+df.format(playerW/10)+"%");//
		System.out.println("The dealer has won "+ dealerWins+" times. A percentage of "+df.format(dealerW/10)+"%");
		System.out.println("There has been "+ties+" pushes. A percentage of "+df.format(pushes/10)+"%");
	}
}
