package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import blackjack.Card.Rank;
import blackjack.Card.Suit;

public class Driver {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		Dealer dealer = new Dealer(); dealer.setName("Dealer");
		Player player = new Player(5000); player.setName("Player");
		
		List<Card> deck = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		

		System.out.println("Welcome to the table!\nBlackjack pays 3 to 2.\n");
		
		while(player.money > 0) {
			
			System.out.println("\n---------------------------------------------------------------------");
			
			player.hand = new ArrayList<Card>();
			dealer.hand = new ArrayList<Card>();
			
			System.out.print("Remaining money: " + player.money + "\nPlease place your bet: ");		
			
			int bet = sc.nextInt();
			while(bet > player.money) {
				System.out.print("\nNot enough money! You have " + player.money
						+ "\nPlease place you bet: ");
				bet = sc.nextInt();
			}
			player.money -= bet;
					
			for (int i = 0; i < 2; i++) {
				player.recieveCard(dealer.deal(deck));
				}
			System.out.print("\nPlayer's Hand: ");
			player.hand.forEach(card -> System.out.print(card.getCard() + " "));
						
			for (int i = 0; i < 2; i++) {
				dealer.recieveCard(dealer.deal(deck));
				}
			System.out.print("\nDealer's hand shown: ");
			System.out.println(dealer.hand.get(0).getCard() + "\n");
			
			if (Helper.points(player.hand) == 21) {
				System.out.println("Congratulations! You got a black jack!");
				player.money += bet * 2.5;
				continue;
			}
			
			String choice = "";
			
			System.out.print("Please make a choice (h : hit | s : stand | sp : split | "
					+ "d : doubling down | su : surrender): ");
			choice = sc.next();
						
			
			switch(choice) {
			
			case "h": 
				do{					
					player.recieveCard(dealer.deal(deck));
					Helper.showHand(player);
					
					if (Helper.points(player.hand) <= 21) {
						System.out.print("\nPlease make a choice (h : hit | s : stand): ");
						choice = sc.next();
					}else {break;}					
				}while (choice.equals("h"));
				break;
			case "s":
				break;
			case "sp":
				break;
			case "d": 
				if (bet <= player.money) {
					player.money -= bet;
					bet *= 2;	
					player.recieveCard(dealer.deal(deck));
				}else {
					System.out.println("Not enough money.\nMoney remaining: " + player.money
							+ " | Bet: " + bet);
				}
				break;
			case "su":
				player.money += bet/2;
				System.out.println("\nPlayer surrendered.");
				continue;
			}
			
			System.out.println();
			
			Helper.showHand(player);
			
			if (Helper.points(player.hand) > 21) {
				System.out.println("You busted!");
			}else {
				
				while(Helper.points(dealer.hand) < 17){
					dealer.recieveCard(dealer.deal(deck));
				}
				
				Helper.showHand(dealer);
				
				
//				if (Helper.points(dealer.hand) > 21) {
//					System.out.println("\nDealer busted!");
//					player.money += bet * 2;
//				}else if (Helper.points(player.hand) == Helper.points(dealer.hand)) {
//					System.out.println("\nThis hand is a tie");
//					player.money += bet;
//				}else if (Helper.points(player.hand) > Helper.points(dealer.hand)) {
//					System.out.println("You won this hand!");
//					player.money += bet*2;
//				}else {
//					System.out.println("\nYou lost this hand");
//				}
				
				Helper.judge(Helper.points(player.hand), Helper.points(dealer.hand), bet, player.money);
			}

		}
			
		System.out.println("\n******You ran out of money, good luck next time!******");
		

	}
	
	

}