package project1;

public class Blackjack {
	private Deck d;
	private Hand playerHand;
	private Hand dealerHand;
	
	public Blackjack() {
		reset(true);
	}
	
	public void reset(boolean newDeck) {
		if(newDeck) {
			d = new Deck();
			d.shuffle();
			playerHand = new Hand();
			dealerHand = new Hand();
		}
	}
	
	public void deal() {
		for(int i=0; i<2; i++) {
			playerHand.add(d.deal());
			dealerHand.add(d.deal());
		}
	}
	
	public String toStrng() {
		String s = "The player has "+ playerHand.toString()+".\n";
		s += "The delaer has "+ dealerHand.toString()+".\n";
		s += "These are the cards left in the deck:"+ d.toString()+".";
		return s;
	}
	
	public boolean playerTurn() {
		while(playerHand.getTotalValue()<16) {
			playerHand.add(d.deal());
		}
		if(playerHand.getTotalValue()>21) {
			return false;
		}
		return true;
	}
	
	public boolean dealerTurn() {
		while(dealerHand.getTotalValue()<17) {
			dealerHand.add(d.deal());
		}
		if(dealerHand.getTotalValue()>21) {
			return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		game.deal();
		System.out.println(game.toString());
		if (!game.playerTurn()) {
			System.out.println("The player went bust! Dealer wins!!!");
		}
		else if(!game.dealerTurn()) {
			System.out.println("The dealer went bust! Player wins!!!");
		}
		else {
			int dealerP = game.dealerHand.getTotalValue();
			int playerP = game.playerHand.getTotalValue();
			if(dealerP>playerP) {
				System.out.println("The dealer has "+dealerP+". The player has "+playerP+".\nThe dealer has won!!!");
			}
			else if(dealerP<playerP) {
				System.out.println("The dealer has "+dealerP+". The player has "+playerP+".\nThe player has won!!!");
			}
			else {
				System.out.println("The dealer has "+dealerP+". The player has "+playerP+".\nIt's a tie!");
			}	
		}
		

	}

}
