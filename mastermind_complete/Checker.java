/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;


public class Checker {
    public static boolean check(String guess) {
        if (guess.length() != GameConfiguration.pegNumber) {
            return false;
        }
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (!isValidColor(Character.toString(c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColor(String color) {
        for (String validColor : GameConfiguration.colors) {
            if (validColor.equals(color)) {
                return true;
            }
        }
        return false;
    }
}
