package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import blackjack.Card.Rank;
import blackjack.Card.Suit;

public class Dealer extends Person{
	
	public Card deal(List<Card> deck){		
		
		Random random = new Random();
		int randomNumber = random.nextInt(52);
		
		return deck.get(randomNumber);		
	}

}
