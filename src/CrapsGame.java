import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static int rollDice() {
        Random rnd = new Random();
        return rnd.nextInt(6) + 1;
    }

    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        int die1 = rollDice();
        int die2 = rollDice();
        int sum = die1 + die2;
        System.out.println("You rolled a " + die1 + " and a " + die2 + ". Total: " + sum);

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You lose.");
        } else if (sum == 7 || sum == 11) {
            System.out.println("Natural! You win.");
        } else {
            int point = sum;
            System.out.println("Point is set to " + point + ". Now try to roll the point before getting a 7!");

            boolean keepRolling = true;
            while (keepRolling) {
                die1 = rollDice();
                die2 = rollDice();
                sum = die1 + die2;
                System.out.println("You rolled a " + die1 + " and a " + die2 + ". Total: " + sum);

                if (sum == point) {
                    System.out.println("You made your point! You win.");
                    keepRolling = false;
                } else if (sum == 7) {
                    System.out.println("You rolled a 7! You lose.");
                    keepRolling = false;
                } else {
                    System.out.println("Rolling again... trying to hit the point.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playCraps();

            System.out.print("Do you want to play again? (yes or no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing!");
            }
        }
        scanner.close();
    }
}
