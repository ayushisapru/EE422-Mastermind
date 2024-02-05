/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;


public class GameResult {
    private int black;
    private int white;

    public GameResult(int black, int white) {
        this.black = black;
        this.white = white;
    }

    public int getBlack(){
        return black;
    }

    public int getWhite(){
        return white;
    }
}