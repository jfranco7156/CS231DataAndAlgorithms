package project1;

import java.util.Scanner;

public class InteractiveGame {
	private static String response;
	private static Scanner input;
	private static Blackjack game;
	static int playerWins;
	static int dealerWins;
	static int ties;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		game = new Blackjack();
		welcomeBlackjack();
		playerWins = 0;
		dealerWins = 0;
		ties = 0;
		game.deal();
		System.out.println("The game will now begin....\nYou weare currently dealt "+game.getPlayerHand()+".\n"
				+ "It has a total value of "+game.getPlayerHand().getTotalValue()+"\nThe dealer was dealt ");
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
	
	public static void welcomeBlackjack() {
		System.out.println("Hello!\nWelcome to the game of Blackjack!\nWould you like to know the rules first or dive right into the game?\n"
				+ "Type 'Rules' to get some rules or 'Begin' to start a round of Blackjack");
		response = promptInput();
		while(!response.toLowerCase().equals("rules") && !response.toLowerCase().equals("begin")) {
			System.out.println(!response.toLowerCase().equals("rules"));
			System.out.println(!response.toLowerCase().equals("begin"));
			System.out.println("The text you have typed is not 'rules' or 'begin'\nPlease type 'rules' or 'begin' ONLY!!!");
			response = promptInput();
		}
		if(response.equals("rules")) {
			printRules();
		}
	}
	
	private static void printRules() {
		System.out.println("The goal of blackjack is to beat the dealer's hand without going over 21.\r\n" + 
				"Face cards are worth 10. Aces are worth 1.\r\n" + 
				"Both the player and the dealer start with two cards each.\r\n" + 
				"To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\r\n" + 
				"If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\r\n" + 
				"Dealer will hit until his/her cards total 17 or higher.\r\n");
	}
	
	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

}
