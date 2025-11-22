import java.util.Random;
import java.util.Scanner;

class User {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        if (newPosition < 0 || newPosition > 100) {
            throw new IllegalArgumentException("Position must be between 0 and 100: " + newPosition);
        }
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
        System.out.println("Board Game ");
        System.out.println("Reach 100 to win!");

        try (Scanner sc = new Scanner(System.in)) {
            Board board = new Board();
            User user = new User();

            while (user.getPosition() < 100) {

                System.out.print("Press Enter to roll dice ");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    System.err.println("Input error: " + e.getMessage());
                    continue;
                }

                int dice;
                try {
                    dice = board.rollDice();
                } catch (Exception e) {
                    System.err.println("Failed to roll dice: " + e.getMessage());
                    continue;
                }

                System.out.println("You score: " + dice);

                int currentPosition = user.getPosition() + dice;

                if (currentPosition > 100) {
                    System.out.println("You need exact number to reach 100!");
                    continue;
                }

                currentPosition = board.upWard(currentPosition);
                currentPosition = board.downWard(currentPosition);

                try {
                    user.setPosition(currentPosition);
                } catch (IllegalArgumentException iae) {
                    System.err.println("Invalid position: " + iae.getMessage());
                    continue;
                }

                System.out.println("Your current position: " + user.getPosition());

            }

            System.out.println("You won !!!");

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
