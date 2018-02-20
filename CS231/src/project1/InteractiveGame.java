package project1;

import java.util.Scanner;

public class InteractiveGame {
	private static String response;
	private static Scanner input;
	private static Blackjack game;
	static int playerWins;
	static int dealerWins;
	static int ties;
	static boolean playing;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		game = new Blackjack();
		welcomeBlackjack();
		playerWins = 0;
		dealerWins = 0;
		ties = 0;
		playing = true;
		do {
			game.deal();
			System.out.println("The round will now begin....\nYou were currently dealt "+game.getPlayerHand().toString()+".\n"
					+ "It has a total value of "+game.getPlayerHand().getTotalValue()+"\nThe dealer was dealt "+
					game.getDealerHand().toString()+"\nIt has a total value of "+ game.getDealerHand().getTotalValue()+
					"\nWould you like to stand or hit?");
			String response = checkInput();
			boolean cont = true;
			while(response.equals("hit")) {
				if(game.getD().getDeck().size()<20) {
					game.reset(true);
				}
				cont = game.playerHit();
				if(!cont || game.getPlayerHand().getTotalValue()==21) {
					break;
				}
				System.out.println("You were currently dealt "+game.getPlayerHand().toString()+".\nIt has a total value of "
				+game.getPlayerHand().getTotalValue()+"\nDo you want to 'hit' or 'stand'?");
				response = checkInput();
			}
			
			
			if(!cont) {
				dealerWins++;
				System.out.println("The dealer has won this round :(\nYou were dealt with "
						+game.getPlayerHand().toString()+"\nIt was a total of "+game.getPlayerHand().getTotalValue());
			}
			else if(game.getPlayerHand().getTotalValue()==21) {
				playerWins++;
				System.out.println("You have won this round!!!\nYou were dealt with "+game.getPlayerHand().toString());
			}
			else {
				boolean c = game.dealerTurn();
				System.out.println("It's now the dealers turn....");
				int player = game.getPlayerHand().getTotalValue();
				int dealer = game.getDealerHand().getTotalValue();
				if(!c) {
					playerWins++;
					System.out.println("You won this round!!!\nThe dealer dealt with "+game.getDealerHand().toString()
							+"\nIt has a total value of "+game.getDealerHand().getTotalValue());
				}
				else if(player>dealer) {
					playerWins++;
					System.out.println("You have won this round!!!\nThe dealer dealt with "
							+game.getDealerHand().toString()+"\nIt has a total value of "+game.getDealerHand().getTotalValue());
				}
				else if(player<dealer) {
					dealerWins++;
					System.out.println("The dealer has won this round :(\nThe dealer dealt with "
							+game.getDealerHand().toString()+"\nIt has a total value of "+game.getDealerHand().getTotalValue());
				}
				else {
					ties++;
					System.out.println("This round has ended in a tie...\nThe player has a total of "
							+game.getPlayerHand().getTotalValue()+"\nThe dealer had a total value of "+game.getDealerHand().getTotalValue());
				}
			}
			System.out.println("Do you want to play again?");
			response = promptInput();
			while(!response.toLowerCase().equals("yes") && !response.toLowerCase().equals("no")) {
				System.out.println("Please type 'yes' or 'no' only...");
				response = promptInput();
			}
			if(response.toLowerCase().equals("no")) {
				playing = false;
			}
		}while(playing);
		
		System.out.println("Thanks for playng!");
		System.out.println("You won "+playerWins+" times.\nThe dealer won "+dealerWins+" times.\nThere were "+ties+" pushes");
		System.exit(0);
		
	}
	
	public static void welcomeBlackjack() {
		System.out.println("Hello!\nWelcome to the game of Blackjack!\nWould you like to know the rules first or dive right into the game?\n"
				+ "Type 'Rules' to get some rules or 'Begin' to start a round of Blackjack\nThen press 'Enter'");
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
		System.out.println("-The goal of blackjack is to beat the dealer's hand without going over 21.\n" + 
				"-Face cards are worth 10. Aces are worth 1.\n" + 
				"-Both the player and the dealer start with two cards each.\n" + 
				"-To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n" + 
				"-If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n" + 
				"-Dealer will hit until his/her cards total 17 or higher.\n");
		System.out.println("Press 'Enter' to begin");
		response = promptInput();
	}
	
	public static String checkInput() {
		String s= promptInput();
		while(!s.toLowerCase().equals("hit") && !s.toLowerCase().equals("stand")) {
			System.out.println("The text you have typed is not 'hit' or 'stand'\nPlease type 'hit' or 'stand' ONLY!!!");
			s = promptInput();
		}
		return s.toLowerCase();
	}
	
	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

}
