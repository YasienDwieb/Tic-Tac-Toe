package x_o;

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Anonymous
 */
public class X_O {

    static Scanner scan = new Scanner(System.in);
    static char[] values = new char[9];
    static String[] sum = new String[8];
    
    public static void main(String[] args) {
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (tryTime(i)) {
                draw = false;
                break;
            }
        }
        if (draw) {
            System.out.println("ddddddddddddddddddddd");
        }
    }

    public static boolean tryTime(int i) {
        if (i % 2 == 0) {
            System.out.println("Player One, enter your choice: ");
        } else {
            System.out.println("Player Two, enter your choice: ");
        }
        int value = scan.nextInt();
        return addValue(value, i);

    }

    public static boolean checkWinner(char input) {
        if ((values[0] == input) && (values[1] == input) && (values[2] == input)) {
            return true;
        }
        if ((values[0] == input) && (values[3] == input) && (values[6] == input)) {
            return true;
        }
        if ((values[1] == input) && (values[4] == input) && (values[7] == input)) {
            return true;
        }
        if ((values[2] == input) && (values[5] == input) && (values[8] == input)) {
            return true;
        }
        if ((values[3] == input) && (values[4] == input) && (values[5] == input)) {
            return true;
        }
        if ((values[6] == input) && (values[7] == input) && (values[8] == input)) {
            return true;
        }
        if ((values[0] == input) && (values[4] == input) && (values[8] == input)) {
            return true;
        }
        if ((values[2] == input) && (values[4] == input) && (values[6] == input)) {
            return true;
        }
        return false;
    }

    public static boolean addValue(int value, int chooser) {
        if (values[value - 1] == ' ') {
            if (chooser % 2 == 0) {
                values[value - 1] = 'x';
                if (chooser > 3) {
                    if (checkWinner('x')) {
                        System.out.println("xxxxxxxxxxxxxxxxx");
                        return true;
                    }
                }
                return false;
            } else {
                values[value - 1] = 'o';
                if (chooser > 3) {
                    if (checkWinner('o')) {
                        System.out.println("oooooooooooooo");
                        return true;
                    }
                }
                return false;
            }
        } else {
            System.out.println("Wrong position, Try again");
            tryTime(value);
            return false;
        }
    }
}