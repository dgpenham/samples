import java.util.*;

public class CrapsSimulator {
	/**
	This program simulates 100 rounds of craps using a pseudo-random number generator.
	Each round is a new line; the first pair of numbers on the line represents the value 
	of the first roll of the die. A 7 or 11 is an automatic win; a 2, 3, or 12 is an
	automatic loss.  Otherwise, play continues until the person rolls the same number as
	they did on their first roll (in which case they win) or they roll a 7 (in which case
	they lose).
	At the end it prints out the total number of wins and losses.
	*/
	public static void main(String[] args) {
		
		int wins = 0, losses = 0;
		System.out.println("1st Roll \t Rest of the game");
		
		for (int i = 1; i <= 100; i++){
			Random r = new Random();
			boolean game = craps(r);
		
			if (game)
				wins++;
			else
				losses++;
		}
	
		System.out.println();
		System.out.println("Total wins: " + wins);
		System.out.println("Total losses: " + losses);
	}
	
	public static boolean craps(Random rand){		
		int roll1, roll2, point1, point2;
		roll1 = rand.nextInt(6) + 1;
		roll2 = rand.nextInt(6) + 1;
		int sum = roll1 + roll2;
		System.out.print("[" + roll1 + ", " + roll2 + "]");
		
		if (sum == 7 || sum == 11 || sum == 2 || sum == 3 || sum == 12){			
			if (sum == 7 || sum == 11){
				System.out.println("\tYou win!");
				return true; //to record a win (and exit the method)
			} else if (sum == 2 || sum == 3 || sum == 12){
				System.out.println("\tYou lose");
				return false; //to record a loss (etc)
			}
		}
			int thePoint = sum;
			do {
				point1 = rand.nextInt(6) + 1;
				point2 = rand.nextInt(6) + 1;
				thePoint = point1 + point2;
				System.out.print("[" + point1 + ", " + point2 + "]");
				if (thePoint == sum){
					System.out.println("\tYou win!");
					return true;
				}
			} while (thePoint != 7);	
			System.out.println("\tYou lose");
			return false;
	}
}
