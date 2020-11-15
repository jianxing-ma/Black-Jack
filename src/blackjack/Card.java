package blackjack;

public class Card {
	
	private Suit suit;
	private Rank rank;
	private int value;
	private String card;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.value = rank.value;
		this.card = suit.suit + rank.rank;
	}
	
	public String getSuit() {
		return suit.suit;
	}
		
	public String getRank() {
		return rank.rank;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getCard() {
		return card;
	}


	public enum Suit{
		DIAMOND("\u2666"), SPADE("\u2660"), HEART("\u2665"), CLUB("\u2663");
		
		private final String suit;
		
		Suit(String suit) {
			this.suit = suit;
		}
		
		//public String suit() {return suit;}
	}
	
	public enum Rank{
		TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
		NINE("9", 9), TEN("10", 10), JACK("J", 10), QUEEN("Q", 10), KING("K", 10), ACE("A", 1);
		
		private final String rank;
	    private final int value;
		
		Rank(String rank, int value) {
			this.rank = rank;
			this.value = value;
		}
		
		//private String rank() {return rank;}
		//public int value() {return value;}
	}
}
