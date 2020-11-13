package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Card> hand = new ArrayList<Card>();
	
	public void recieveCard(Card card){
		hand.add(card);
	}
}
