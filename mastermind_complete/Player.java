/* EE422C Assignment #2 submission by
 * Ayushi Sapru
 * as98489
 */

package assignment2;


import java.util.Scanner;

public class Player {
    private Scanner keyboard;

    public Player(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public String makeGuess(){
        System.out.print("\nEnter guess: \n");
        return keyboard.nextLine();
        //System.out.print("\n");
    }
}