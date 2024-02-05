/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;


import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<String> guesses;
    private List<GameResult> results;

    public GameBoard(){
        guesses = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void newGuess(String guess, GameResult result){
        guesses.add(guess);
        results.add(result);
    }

    public void showBoard(){
        for(int i = 0; i < guesses.size(); i++){
            String guess = guesses.get(i);
            GameResult result = results.get(i);
            System.out.printf("%s    %dB_%dW%n", guess, result.getBlack(), result.getWhite());
        }
    }
}
