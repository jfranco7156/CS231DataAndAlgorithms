package project1;

public class Blackjack {
	private Deck d;
	private Hand playerHand;
	private Hand dealerHand;
	
	public Blackjack() {
		reset(true);
		playerHand = new Hand();
		dealerHand = new Hand();
	}
	
	public void reset(boolean newDeck) {
		if(newDeck) {
			d = new Deck();
			d.shuffle();
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

	public int playRound() {
		deal();
		System.out.println(toString());
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
	
	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		for(int i=0; i<6; i++) {
			if(game.d.deck.size()<20) {
				game.reset(true);
			}
			game.playRound();
		}
	}

}
