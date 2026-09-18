package edu.umn.d.cs1632;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initial creating of objects and displaying the csv file
        MArray mArray = new MArray("src/data/simple.csv");
        mArray.DisplayFile();
        System.out.println("Data: ");
        System.out.println(mArray);
        Scanner scanner = new Scanner(System.in);

        //launching information on how to use the program
        System.out.println("Welcome to the visual dataset program.");
        System.out.println("To begin simply type V for vertical vector, H for horizontal vector, or M for submatrix followed by a space then starting coordinates\n" +
                "and then how far you wish to go in that line.\n" +
                "To further explain and give an example for vertical vector the format is V (column, row, (row you wish to go to)) \n" +
                "Format for horizontal vector H (row, column, (column you wish to go to))\n" +
                "Format for submatrix M (row, column, (row you wish to go to), (column you wish to go to)\n" +
                "Example is V 2 2 4 gives you Multi.\n" +
                "To quit enter: Q\n" +
                "TIP: rows and columns start with 0 and spaces are needed between each variable ( V224 will not work, V 2 2 4 will work)");
        //User interactive section of the code
        while (true) {
            System.out.println("What is your Query: ");

            String userInput = scanner.nextLine().toLowerCase();

            String[] inputAsArray = userInput.split("\\s+");


            switch (inputAsArray[0]) {
                case "h":
                    System.out.println(mArray.MArrayHorizontalValues(Integer.parseInt(inputAsArray[1]), Integer.parseInt(inputAsArray[2]), Integer.parseInt(inputAsArray[3])));
                    break;
                case "v":
                    System.out.println(mArray.MArrayVerticalValues(Integer.parseInt(inputAsArray[1]), Integer.parseInt(inputAsArray[2]), Integer.parseInt(inputAsArray[3])));
                    break;
                case "m":
                    System.out.println(mArray.MArraySubMatrixValues(Integer.parseInt(inputAsArray[1]), Integer.parseInt(inputAsArray[2]), Integer.parseInt(inputAsArray[3]), Integer.parseInt(inputAsArray[4])));
                    break;
                case "q":
                    System.out.println("Thank you for using the visual dataset program.");
                    break;
                default:
                    System.out.println("The First character in your phrase wasn't H,V, or M");
                    break;
            }
            if (userInput.equals("q")) {
                break;
            }

        }
    }


}

