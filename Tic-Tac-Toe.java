package tictactoe;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] ticTacToe = new String[3][3];
        int countMark = 0;

        for(int i = 0; i < 3; i++) {
            Arrays.fill(ticTacToe[i], " ");
        }

        while(true) {
            draw(ticTacToe);
            putMark(ticTacToe, countMark);
            countMark = countMark + 1;
            if(analyseResult(ticTacToe)) {
                draw(ticTacToe);
                System.out.println(printResult(countMark));
                break;
            }
            if(countMark == 9) {
                draw(ticTacToe);
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void putMark(String[][] ticTacToe, int countMark) {
        Scanner scanner = new Scanner(System.in);
        //
        int cordX;
        int cordY;

        try {
            while(true) {
                if(waitForGoodCords(ticTacToe, countMark)) {
                    break;
                }
            }

        }
        catch(Exception e) {
        }
        System.out.print("\n");
    }

    public static boolean waitForGoodCords(String[][] ticTacToe, int countMark) {
        Scanner scanner = new Scanner(System.in);
        int cordX;
        int cordY;
        boolean prooced = false;
        try {
            while(true) {
                System.out.print("Enter the coordinates: ");
                cordX = scanner.nextInt();
                cordY = scanner.nextInt();
                int newCordX = 0;
                int newCordY = 0;
                int reverseVar;

                // transition of cords
                for (int i = 0; i < 3; i++) {
                    reverseVar = 2;
                    for (int j = 0; j < 3; j++) {
                        if (cordX - 1 == i && cordY - 1 == j) {
                            newCordX = reverseVar;
                            newCordY = i;
                        }
                        reverseVar = reverseVar - 1;
                    }
                }

                if (cordX < 1 || cordX > 3 || cordY > 3 || cordY < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (ticTacToe[newCordX][newCordY].equals("X") || ticTacToe[newCordX][newCordY].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if(countMark % 2 == 0) {
                        ticTacToe[newCordX][newCordY] = "X";
                    }
                    else
                        ticTacToe[newCordX][newCordY] = "O";

                    prooced = true;
                }
                return prooced;
            }
        }
        catch (Exception e) {
            System.out.println("You should enter numbers!");
        }
        return false;
    }

    public static void draw(String[][] ticTacToe) {
        System.out.println("---------");
        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for(int j = 0; j < 3; j++) {
                System.out.print(ticTacToe[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public static boolean analyseResult(String[][] ticTacToe) {

        // CASE - WINS
        for(int i = 0; i < 3; i++) {
            // POZIOME
            if(ticTacToe[i][0].equals(ticTacToe[i][1]) && ticTacToe[i][0].equals(ticTacToe[i][2]) && !(ticTacToe[i][0].equals(" ")))
                return true;
            // PIONOWE
            if(ticTacToe[0][i].equals(ticTacToe[1][i]) && ticTacToe[0][i].equals(ticTacToe[2][i] ) && !(ticTacToe[0][i].equals(" ")))
                return true;
            // UKOS 1
            if(ticTacToe[0][0].equals(ticTacToe[1][1]) && ticTacToe[0][0].equals(ticTacToe[2][2]) && !(ticTacToe[0][0].equals(" ")))
                return true;
            // UKOS 2
            if(ticTacToe[2][0].equals(ticTacToe[1][1]) && ticTacToe[2][0].equals(ticTacToe[0][2]) && !(ticTacToe[2][0].equals(" ")))
                return true;
        }
        return false;
    }

    public static String printResult(int countMark) {
        if(countMark % 2 == 0) {
            return "O wins";
        }

        return "X wins";
    }
}
