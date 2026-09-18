package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private MArray() {}
    private String fileName;

    public MArray(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method prints out a display of a csv dataset telling you what the value is in each cell, IE, if the cell is a integer, string, or double.
     */
    public void DisplayFile() {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    try {
                        IntValue v = new IntValue(cell);
                        System.out.print(v.getValue() + " (I)" + "\t");
                    } catch (NumberFormatException e) {
                        try {
                            DoubleValue v = new DoubleValue(cell);
                            System.out.print(v.getValue() + " (D)" + "\t");
                        } catch (NumberFormatException error) {
                            StringValue v = new StringValue(cell);
                            System.out.print(v.getValue() + " (S)" + "\t");
                        }
                    }
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gives you the specific value in a cell as the type value
     * @param targetColumn this is the column you are looking for
     * @param targetRow this is the target row you are looking for
     * @return gives you the value in that cell as a value type
     * @throws IllegalArgumentException if the data you are looking at is outside the range of the data set it will throw this exception
     */
    public Value getMArrayValue(int targetColumn, int targetRow) throws IllegalArgumentException{
        String targetCell;
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            if (targetRow < allData.size()) {
                String[] row = allData.get(targetRow);
                if (targetColumn < row.length) {
                    targetCell = row[targetColumn];
                    try {
                        return new IntValue(targetCell);
                    } catch (NumberFormatException e) {
                        try {
                            return new DoubleValue(targetCell);
                        } catch (NumberFormatException error) {
                            return new StringValue(targetCell);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Your target column is outside the bounds of the data.");
                }
            } else {
                throw new IllegalArgumentException("Your target row is outside the bounds of the data.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * gives oyu the row length of the dataset you are looking at
     * @return the row length of the data set
     */
    public int getMArrayRowLength() {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            return allData.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * This method gives you the column length of the data set
     * @return gives you the length of the data set
     */
    public int getMArrayColumnLength() {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            return allData.get(1).length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * When given a specific cell it will check the cells horizontally from that position to see if those cell values are all of the same type or not.
     * If not they return multi, if so they return the type.
     * This method can go backwards and forwards, IE, if given a row of 2, column of 4 and distance of 1 you will first go to row 2, column 4 then backwards to row 2, column 1 telling
     * you the cell values in between those two given points.
     * @param row target row you wish to look at
     * @param column target column you wish to look at
     * @param distance the column you wish to go to. This column can be before or after the target column you are looking at.
     * @return gives you what the type of values are in that given section of the data as a String. Multi if their are multiple types and the specific type of their is only 1 type.
     */
    public String MArrayHorizontalValues(int row, int column, int distance) {
        ArrayList<Value> list = new ArrayList<>();
        int inLineColumn = column;

        if (distance < column && distance >= 0) {
            for (int i = 0; i <= column - distance; i++) {
                list.add(getMArrayValue(inLineColumn, row));
                inLineColumn--;
            }
            if (list.stream().filter(java.util.Objects::nonNull).map(Object::getClass).distinct().count() <= 1) {
                return list.getFirst().getType();
            } else {
                return "Multi";
            }

        } else if (distance == column) {
            return getMArrayValue(inLineColumn, row).getType();
        } else if (distance > column && distance <= getMArrayColumnLength()) {
            for (int i = 0; i <= distance - column; i++) {
                list.add(getMArrayValue(inLineColumn, row));
                inLineColumn++;
            }
            if (list.stream().filter(java.util.Objects::nonNull).map(Object::getClass).distinct().count() <= 1) {
                return list.getFirst().getType();
            } else {
                return "Multi";
            }
        } else if (distance > getMArrayColumnLength()) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (distance < 0 ) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
            System.out.println("You requested something outside the length of the code");
            return null;
        }
        System.out.println("Something went wrong.");
        return null;
    }

    /**
     * When given a specific cell it will check the cells vertically from that position to see if those cell values are all of the same type or not.
     * If not they return multi, if so they return the type.
     * This method can go backwards and forwards, IE, if given a column of 2, row of 4 and distance of 1 you will first go to column 2, row 4 then backwards to column 2, row 1 telling
     * you the cell values in between those two given points.
     * @param column target column you are looking for
     * @param row target row you are looking for
     * @param distance the row you wish to go to. this can be before or after the target row you are looking for.
     * @return gives you what the type of values are in that given section of the data as a String. Multi if their are multiple types and the specific type of their is only 1 type.
     */
    public String MArrayVerticalValues(int column, int row, int distance) {
        ArrayList<Value> list = new ArrayList<>();
        int inLineRow = row;

        if (distance < row && distance >= 0) {
            for (int i = 0; i <= row - distance; i++) {
                list.add(getMArrayValue(column, inLineRow));
                inLineRow--;
            }
            if (list.stream().filter(java.util.Objects::nonNull).map(Object::getClass).distinct().count() <= 1) {
                return list.getFirst().getType();
            } else {
                return "Multi";
            }

        } else if (distance == row) {
            return getMArrayValue(column, inLineRow).getType();
        } else if (distance > row && distance <= getMArrayRowLength()) {
            for (int i = 0; i <= distance - column; i++) {
                list.add(getMArrayValue(column, inLineRow));
                inLineRow++;
            }
            if (list.stream().filter(java.util.Objects::nonNull).map(Object::getClass).distinct().count() <= 1) {
                return list.getFirst().getType();
            } else {
                return "Multi";
            }
        } else if (distance > getMArrayRowLength()) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (distance < 0 ) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
            System.out.println("You requested something outside the length of the code");
            return null;
        }
        System.out.println("Something went wrong.");
        return null;

    }

    /**
     * When given a specific row and column and a second row and column it tells you if the values in between those cells are all of the same type or different types.
     * @param row the integer value of the first row you wish to look at
     * @param column the integer value of the first column you wish to look at
     * @param rDistance the end point, were you wish to go, or second row you wish to look at
     * @param cDistance the end point, were you wish to go, or second column you wish to look at
     * @return Gives you multi if there are multiple types within the given submatrix or a specific value if they are all of the same type.
     */
    public String MArraySubMatrixValues(int row, int column, int rDistance, int cDistance) {

        int inLineRow = row;
        ArrayList<String> itemsToCheck = new ArrayList<>();

        if (rDistance < row && rDistance >= 0) {
            for (int i = 0; i <= row - rDistance; i++) {
                itemsToCheck.add(MArrayHorizontalValues(inLineRow, column, cDistance));
                inLineRow--;
            }
            for (String s : itemsToCheck) {
                if (!Objects.equals((s), itemsToCheck.getFirst())) {
                    return "Multi";
                }
            }
            return itemsToCheck.getFirst();

        } else if (rDistance == row) {
            return MArrayHorizontalValues(row, column, cDistance);
        } else if (rDistance > row && rDistance <= getMArrayRowLength()){
            for (int i = 0; i <= rDistance - row; i++) {
                itemsToCheck.add(MArrayHorizontalValues(inLineRow, column, cDistance));
                inLineRow++;
        }
            for (String s : itemsToCheck) {
                if (!Objects.equals((s), itemsToCheck.getFirst())) {
                    return "Multi";
                }
            }
            return itemsToCheck.getFirst();
        } else if (rDistance > getMArrayRowLength()) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (rDistance < 0 ) {
            System.out.println("You requested something that is outside the length of the data try again.");
            return null;
        } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
            System.out.println("You requested something outside the length of the code");
            return null;
        }
        System.out.println("Something went wrong.");
        return null;
    }


}

