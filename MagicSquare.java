/**
* @author: Sebastian Duenas Jr
* @written: 11/27/2020
* @description: A java program that prompts the user for nine numbers. 
*               In those nine numbers, the program will determine if 
*               the sum of the numbers is the same in each row, column
*               and main diagonal. 
*     Algorithm:
*        1). Prompt the user to enter nine numbers.
*        2). Create a nested for-loop that will hold the numbers inside
*            their particular grid.
*        3). Create a method called displayGrid that will display the 
*            grid using a nested for-loop to display the columns and
*            rows.
*        4). Create a boolean method called isCorrect that will determine
*            if the number size is nine or not.
*        5). Create a boolean method called isMagicSquare that will 
*            calculate every condition possible in a magic square, such as
*            the left diagonal and right diagonal
*        6). Create a int method called getRowTotal that will calculate the
*            total of an entire row.
*        7). Create a int method called getColTotal that will calculate the
*            total of an entire column.
*        8). Create a int method called getRightDiag that will calculate the
*            total of the right diagonal.
*        9). Create a int method called getLeftDiag that will calculate the 
*            total of the left diagonal.
*/
import java.util.ArrayList; // Needed to hold the numbers in the array
import java.util.Scanner; // Needed for the scanner class
public class MagicSquare {
    public static void main(String[] args) {
        // Create a Scanner object to read input.
        Scanner input = new Scanner(System.in);
        // Create an ArrayList object to hold numbers.
        ArrayList < Integer > numbers = new ArrayList < > ();
        // Create a 2-D array to hold nine numbers
        int[][] arr = new int[3][3];

        System.out.println("Enter nine numbers in the order you like");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = input.nextInt();
                numbers.add(arr[i][j]);
            }
        }
        System.out.println();
        System.out.println("Here's the magic square you entered:");
        //displays the grid/square 
        displayGrid(arr);
        //holds the result of the magic square
        boolean solvingSquare = isMagicSquare(arr, numbers);
        if (solvingSquare == true) {
            System.out.println();
            System.out.println("You found a magic square!");
        } else if (solvingSquare == false) {
            System.out.println();
            System.out.println("The numbers you entered are not a magic square.");
        }
        boolean value = isCorrect(numbers);
        if (value == false) {
            System.out.println("Because, the numbers 1-9 are not present or it's a repetition between numbers.");
        }
    }
    /**
     * The displayGrid method accepts an argument and 
     * prints out the grid including rows and columns.
     *
     * @param arr  The user's array response
     **/
    public static void displayGrid(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.println();
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + "\t");
            }
        }
    }

    /**
     * The isCorrect method accepts an argument and 
     * determines if the number required is given.
     *
     * @param numbers  The user's array response
     **/
    public static boolean isCorrect(ArrayList < Integer > numbers) {
        boolean value = true;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) < 0 || numbers.get(j) > numbers.size() || numbers.get(i) == numbers.get(j)) {
                    value = false;

                }
            }

        }
        return value;

    }

    /**
     * The isMagicSquare method accepts two arguments and 
     * determines based on isRow, isColumn, leftDiag, and 
     * rightDiag if there is a magic square or not.
     *
     * @param arr  The user's array response
     * @param arr1 The user's array response for column and row
     **/
    public static boolean isMagicSquare(int[][] arr, ArrayList < Integer > arr1) {
        boolean isMagic = false;
        int[] rowTotal = new int[arr.length];
        int[] colTotal = new int[arr[0].length];
        for (int i = 0; i < rowTotal.length; i++) {
            rowTotal[i] = getRowTotal(arr, i);
            colTotal[i] = getColTotal(arr, i);
        }
        int rightDiag = getRightDiag(arr);
        int leftDiag = getLeftDiag(arr);

        boolean isRow = true;
        for (int i = 0; i < rowTotal.length; i++) {
            for (int j = 0; j < rowTotal.length; j++) {
                if (rowTotal[i] != rowTotal[j]) {
                    isRow = false;
                }
            }
        }
        boolean isCol = true;
        for (int i = 0; i < colTotal.length; i++) {
            for (int j = 0; j < colTotal.length; j++) {
                if (colTotal[i] != colTotal[j]) {
                    isCol = false;
                }
            }
        }
        boolean isRightDiag = true;
        if (rightDiag == colTotal[0] && rightDiag == colTotal[0]) {
            isRightDiag = true;
        }

        boolean isLeftDiag = false;
        if (leftDiag == colTotal[0] && leftDiag == colTotal[0]) {
            isLeftDiag = true;
        }
        if (isCol && isLeftDiag && isRightDiag && isRow && isCorrect(arr1)) {
            isMagic = true;
        }
        return isMagic;

    }

    /**
     * The getRowTotal method accepts two arguments and gets
     * the total of each row.
     *
     * @param arr   The user's array response
     * @param row   The user's stored amount of each row
     **/
    public static int getRowTotal(int[][] arr, int row) {
        int total = 0;
        for (int col = 0; col < arr.length; col++) {
            total += arr[row][col];
        }
        return total;
    }

    /**
     * The getColTotal method accepts two arguments and gets
     * the total of each col.
     *
     * @param arr   The user's array response
     * @param col  The user's stored amount of each column
     **/
    public static int getColTotal(int[][] arr, int col) {
        int total = 0;
        for (int row = 0; row < arr.length; row++) {
            total += arr[row][col];
        }
        return total;
    }

    /**
     * The getRightDiag method accepts an argument and gets
     * the total for the right diagonal
     *
     * @param arr   The user's array response
     **/
    public static int getRightDiag(int[][] arr) {
        int total = 0;
        for (int i = 0; i < arr[0].length; i++) {
            total += arr[i][i];
        }
        return total;
    }

    /**
     * The getLeftDiag method accepts an argument and gets
     * the total for the left diagonal
     *
     * @param arr   The user's array response
     **/
    public static int getLeftDiag(int[][] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][arr.length - 1 - i];
        }

        return total;
    }
}