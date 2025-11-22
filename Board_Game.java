import java.util.Random;
import java.util.Scanner;

class User {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
}

class Board {
    private Random rand = new Random();

    public int rollDice() {
        return rand.nextInt(6) + 1;
    }

    public int upWard(int pos) {
        switch (pos) {
            case 7:
                System.out.println("Ladder! Move to 32");
                return 32;
            case 57:
                System.out.println("Ladder! Move to 77");
                return 77;
            
        }
        return pos;
    }

    public int downWard(int pos) {
        switch (pos) {
            case 25:
                System.out.println("Snake! Go back to 9");
                return 9;
            case 92:
                System.out.println("Snake! Go back to 37");
                return 37;
            case 66:
                System.out.println("Snake! Go back to 49");
                return 49;
            
        }
        return pos;
    }
}

public class Board_Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        User user = new User();

        System.out.println("Board Game ");
        System.out.println("Reach 100 to win!");
     

        while (user.getPosition() < 100) {

            System.out.print("Press any key to roll dice ");
            sc.nextLine();

            int dice = board.rollDice();
            System.out.println("You score: " + dice);

            int currentPosition = user.getPosition() + dice;

            if (currentPosition > 100) {
                System.out.println("You need exact number to reach 100!");
                continue;
            }

            currentPosition = board.upWard(currentPosition);
            currentPosition = board.downWard(currentPosition);

            user.setPosition(currentPosition);

            System.out.println("Your current position: " + user.getPosition());
            
        }

        System.out.println("You won !!!");
    }
}
