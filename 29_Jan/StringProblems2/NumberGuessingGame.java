import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = (int) (Math.random() * 100) + 1;
        int guess = 0;
        int count = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (guess != number) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            count++;

            if (guess < number) {
                System.out.println("Too low! Try again.");
            } else if (guess > number) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + count + " tries!");
            }
        }

        scanner.close();
    }
}
