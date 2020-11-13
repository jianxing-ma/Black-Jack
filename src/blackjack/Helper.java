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
	
	public static void judge(int playerPoints, int dealerPoints, int bet, int money) {
		if (dealerPoints > 21) {
			System.out.println("\nDealer busted!");
			money += bet * 2;
		}else if (playerPoints == dealerPoints) {
			System.out.println("\nThis hand is a tie");
			money += bet;
		}else if (playerPoints > dealerPoints) {
			System.out.println("You won this hand!");
			money += bet*2;
		}else {
			System.out.println("\nYou lost this hand");
		}
	}
}
