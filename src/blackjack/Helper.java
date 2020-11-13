package blackjack;

import java.util.List;

public class Helper {

	public static int points(List<Card> hand) {
		int points = 0;
		for (Card car : hand) {
			points += car.getValue();
		}
		return points;
	}
	
	public static void showHand(Person person) {
		System.out.print(person.getName() + "'s Hand: ");
		person.hand.forEach(c -> System.out.print(c.getCard() + " "));
		System.out.println();
	}
}
