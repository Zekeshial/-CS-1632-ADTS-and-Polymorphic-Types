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
        System.out.println("To begin simply type V fir vertical vector, H for horizontal vector, or M for submatrix followed by the starting coordinates\n" +
                "and then how far you wish to go in that line.\n" +
                "For example if you type H 4 2 3 it will scan the data on the 4th column, 2rd row, for 3 total values giving you the answer of multi because you have\n" +
                "two integers and one double.\n" +
                "To quit enter: Q\n" +
                "TIP: rows and columns start with 0");
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

