package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Player extends Person{
	
	public int money;
	
	Player(int money){
		this.money = money;
	}
	
	public int bet() {
		Scanner sc = new Scanner(System.in);
		int bet = sc.nextInt();
		this.money -= bet;
		return bet;
	}	
	

	
//	public void recieveCard(Card card){
//		hand.add(card);
//	}
}
