/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;

public class Driver {
    public static void main(String[] args) {
        boolean testing = (args.length > 0 && args[0].equals("1"));
        Game game = new Game(testing);
        game.runGame();
    }
}
