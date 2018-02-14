package project1;
/**
 * File: Simulation.java
 * Author: Jenniber Franco
 * Date: 02/09/2018
 */

import java.text.DecimalFormat;

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
			if(winner==-1) {
				dealerWins++;
			}
			else if(winner==1) {
				playerWins++;
			}
			else {
				ties++;
			}
		}
		DecimalFormat df = new DecimalFormat("#.#");
		double playerW = (double) playerWins;
		double dealerW = (double) dealerWins;
		double pushes = (double) ties;
		System.out.println("The player has won " + playerWins+" times. A percentage of "+df.format(playerW/10)+"%");
		System.out.println("The dealer has won "+ dealerWins+" times. A percentage of "+df.format(dealerW/10)+"%");
		System.out.println("There has been "+ties+" pushes. A percentage of "+df.format(pushes/10)+"%");
	}
}
