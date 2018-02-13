package project1;

/**
 * File: Simulation.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

public class Simulation {

	public static void main(String[] args) {
		int playerWins = 0;
		int dealerWins = 0;
		int ties = 0;
		Blackjack game = new Blackjack();
		for(int i=0; i<1000; i++) {
			if(game.getD().getDeck().size()<20) {
				game.reset(true);
			}
			int winner = game.playRound();
			if(winner==0) {
				ties++;
			}
			else if(winner==1) {
				playerWins++;
			}
			else {
				dealerWins++;
			}
		}
		System.out.println("The player has won " + playerWins+" times. A percentage of "+(playerWins/10));
		System.out.println("The dealer has won "+ dealerWins+" times. A percentage of "+(dealerWins/10));
		System.out.println("There has been "+ties+" pushes.");
	}

}
