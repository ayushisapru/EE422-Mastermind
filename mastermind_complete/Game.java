/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;

import java.util.Scanner;

public class Game {
    private boolean testing;
    private Scanner scanner;

    public Game(boolean testing) {
        this.testing = testing;
        this.scanner = new Scanner(System.in);
    }

    public void runGame() {
        while (true) {
            playGame();

            System.out.print("Are you ready for another game? (Y/N): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private void playGame() {
        String secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
        Player player = new Player(scanner);
        GameBoard board = new GameBoard();

        System.out.print("\nWelcome to Mastermind. Here are the rules.\nThis is a text version of" +
                        " the classic board game Mastermind.\nThe computer will think of a secret code. " +
                        "The code consists of 4\ncolored pegs. The pegs MUST be one of six colors: blue, green," +
                        "\norange, purple, red, or yellow. A color may appear more than once in\n" +
                        "the code. You try to guess what colored pegs are in the code and\n" + "what order they " +
                        "are in. After you make a valid guess the result\n" +"(feedback) will be displayed.\n" +
                        "The result consists of a black peg for each peg you have guessed\n" +
                        "exactly correct (color and position) in your guess. For each peg in\n" +
                        "the guess that is the correct color, but is out of position, you get\n" +
                        "a white peg. For each peg, which is fully incorrect, you get no\n" + "feedback." +
                        "\nOnly the first letter of the color is displayed. B for Blue, R for\n" +
                        "Red, and so forth. When entering guesses you only need to enter the\n" +
                        "first character of each color as a capital letter.\n" +
                        "You have 12 guesses to figure out the secret code or you lose the\ngame. Are you " +
                        "ready to play? (Y/N): ");

        String begin = scanner.nextLine();
        if (begin.equalsIgnoreCase("Y")) {
            System.out.println("\n\nGenerating secret code ...");
        }

        SecretCodeGenerator.getInstance().getNewSecretCode();

        int guessesLeft = GameConfiguration.guessNumber;

        while (guessesLeft > 0) {
            System.out.println("You have " + guessesLeft + " guesses left.\nWhat is your next guess?\nType in " +
                    "the characters for your guess and press enter.");
            String guess = player.makeGuess();

            if (guess.equalsIgnoreCase("HISTORY")) {
                board.showBoard();
                continue;
            }

            if (!Checker.check(guess)) {
                System.out.println(guess + " -> INVALID GUESS\n");
                continue;
            }

            GameResult result = Calculator.calculate(guess, secretCode);
            board.newGuess(guess, result);

            if (result.getBlack() == GameConfiguration.pegNumber) {
                System.out.println(guess + " -> Result: " + GameConfiguration.pegNumber + "B_0W - You win !!");
                break;
            } else {
                System.out.printf("%s -> Result: %d B_%d W%n", guess, result.getBlack(), result.getWhite());
            }

            guessesLeft--;
        }

        if (guessesLeft == 0) {
            System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
        }

        //board.showBoard();
    }


}
