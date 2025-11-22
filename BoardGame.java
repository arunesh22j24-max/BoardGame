import java.util.Scanner;
import java.util.Random;

public class BoardGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int position = 0;
		int dice;

		System.out.println("----- BoardGame -----");
		System.out.println("Reach 100 to win!");
		

		while (position < 100) {

			System.out.print("Press any key to roll the dice ");
			sc.nextLine();

			dice = rand.nextInt(6) + 1;
			System.out.println("You score: " + dice);

			position = position + dice;


			if (position > 100) {
				position = position - dice;
				System.out.println("You need exact number to reach 100!");
			}


			if (position == 9) {
				System.out.println("Ladder! Move to 32");
				position = 32;
			}
			else if (position == 25) {
				System.out.println("Ladder! Move to 42");
				position = 42;
			}
			else if (position == 57) {
				System.out.println("Ladder! Move to 72");
				position = 72;
			}


			if (position == 26) {
				System.out.println("Snake! Go back to 4");
				position = 4;
			}
			else if (position == 86) {
				System.out.println("Snake! Go back to 16");
				position = 16;
			}
			else if (position == 98) {
				System.out.println("Snake! Go back to 77");
				position = 77;
			}
			

			System.out.println("Your current Score: " + position);
			
			}

		System.out.println(" You won the game!");
	}
}
