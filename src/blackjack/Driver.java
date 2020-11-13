package blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
			int bet = player.bet();
					
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
						
			do {
				
				System.out.print("Please make a choice (h : hit | s : stand | sp : split | "
						+ "d : doubling down | su : surrender): ");
				choice = sc.next();
				
				switch(choice) {
				case "h": 
					player.recieveCard(dealer.deal(deck));
					Helper.showHand(player);
					break;
				case "sp": 
					
					break;
				}
			}while((choice.equals("h") || choice.equals("sp") ) && Helper.points(player.hand) <= 21);
			
			switch(choice) {
			case "d": 
				player.money -= bet;
				bet *= 2;	
				player.recieveCard(dealer.deal(deck));
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
								
				int dealerPoints = Helper.points(dealer.hand);
				
				
				if (dealerPoints > 21) {
					System.out.println("\nDealer busted!");
					player.money += bet * 2;
				}else if (Helper.points(player.hand) == dealerPoints) {
					System.out.println("\nPush");
					player.money += bet;
				}else if (Helper.points(player.hand) > dealerPoints) {
					System.out.println("You won!");
					player.money += bet*2;
				}else {
					System.out.println("\nYou lost");
				}
			}

		}
			
		System.out.println("\n******You ran out of money, good luck next time!******");
		

	}
	
	

}
