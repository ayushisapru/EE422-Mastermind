/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;


public class Calculator {
    public static GameResult calculate(String guess, String secret){
        int black = 0;
        int white = 0;
        boolean[] guessUsed = new boolean[GameConfiguration.pegNumber];
        boolean[] secretUsed = new boolean[GameConfiguration.pegNumber];

        for (int i = 0; i < GameConfiguration.pegNumber; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                black++;
                guessUsed[i] = true;
                secretUsed[i] = true;
            }
        }

        // Calculate white pegs
        for (int i = 0; i < GameConfiguration.pegNumber; i++) {
            for (int j = 0; j < GameConfiguration.pegNumber; j++) {
                if (!guessUsed[i] && !secretUsed[j] && guess.charAt(i) == secret.charAt(j)) {
                    white++;
                    guessUsed[i] = true;
                    secretUsed[j] = true;
                    break;
                }
            }
        }

        return new GameResult(black, white);
    }
}
