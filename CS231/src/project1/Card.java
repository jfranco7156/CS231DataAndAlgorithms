package project1;

public class Card {
	private int value;
	
	public Card() {
		this.value = (int) (Math.random()*11);
	}
	
	public Card(int v) {
		if(v>0 && v<=10) {
			this.value = v;
		}
		else {
			System.out.println("Value of card must be and integer between 1 and 10");
		}
	}
	
	public static void main(String[] args) {
		Card c = new Card();
	}
	
	public int getValue() {
		return this.value;	
	}
}
