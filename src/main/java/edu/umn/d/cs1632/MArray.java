package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
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
            for (int i = 0; i < distance - column; i++) {
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
            for (int i = 0; i < distance - column; i++) {
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

    public String MArraySubMatrixValues(int row, int column, int rDistance, int cDistance) {
        ArrayList<ArrayList<Value>> mList = new ArrayList<>();
        ArrayList<Value> list = new ArrayList<>();
        int inLineColumn = column;
        int inLineRow = row;

        if (rDistance < row && rDistance >= 0) {
            for (int i = 0; i <= row - rDistance; i++) {
                if (cDistance < column && cDistance >= 0) {
                    for (int x = 0; x <= column - cDistance; x++) {
                        list.add(getMArrayValue(inLineColumn, inLineRow));
                        inLineColumn--;
                    }
                } else if (cDistance == column) {
                    list.add(getMArrayValue(inLineColumn, inLineRow));
                } else if (cDistance > column && cDistance < getMArrayColumnLength()) {
                    for (int x = 0; x < cDistance - column; x++) {
                        list.add(getMArrayValue(inLineColumn, inLineRow));
                        inLineColumn++;
                    }
                } else if (cDistance > getMArrayColumnLength()) {
                    System.out.println("You requested something that is outside the length of the data try again.");
                    return null;
                } else if (cDistance < 0) {
                    System.out.println("You requested something that is outside the length of the data try again.");
                    return null;
                } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
                    System.out.println("You requested something outside the length of the code");
                    return null;
                }
                mList.add(list);
                inLineRow++;
            }
            if (mList.stream().flatMap(List::stream).allMatch(element -> element.equals(list.getFirst()))) {
                return mList.getFirst().getFirst().getType();
            } else {
                return "Multi";
            }
        } else if (rDistance == row) {
            if (cDistance < column && cDistance >= 0) {
                for (int x = 0; x <= column - cDistance; x++) {
                    list.add(getMArrayValue(inLineColumn, row));
                    inLineColumn--;
                }
            } else if (cDistance == column) {
                list.add(getMArrayValue(inLineColumn, row));
            } else if (cDistance > column && cDistance < getMArrayColumnLength()) {
                for (int x = 0; x < cDistance - column; x++) {
                    list.add(getMArrayValue(inLineColumn, row));
                    inLineColumn++;
                }
            } else if (cDistance > getMArrayColumnLength()) {
                System.out.println("You requested something that is outside the length of the data try again.");
                return null;
            } else if (cDistance < 0) {
                System.out.println("You requested something that is outside the length of the data try again.");
                return null;
            } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
                System.out.println("You requested something outside the length of the code");
                return null;
            }
            mList.add(list);
            if (mList.stream().flatMap(List::stream).allMatch(element -> element.equals(list.getFirst()))) {
                return mList.getFirst().getFirst().getType();
            } else {
                return "Multi";
            }
        } else if (rDistance > row && rDistance <= getMArrayRowLength()){
            for (int i = 0; i <= rDistance - row; i++) {
                if (cDistance < column && cDistance >= 0) {
                    for (int x = 0; x <= column - cDistance; x++) {
                        list.add(getMArrayValue(inLineColumn, inLineRow));
                        inLineColumn--;
                    }
                } else if (cDistance == column) {
                    list.add(getMArrayValue(inLineColumn, inLineRow));
                } else if (cDistance > column && cDistance < getMArrayColumnLength()) {
                    for (int x = 0; x < cDistance - column; x++) {
                        list.add(getMArrayValue(inLineColumn, inLineRow));
                        inLineColumn++;
                    }
                } else if (cDistance > getMArrayColumnLength()) {
                    System.out.println("You requested something that is outside the length of the data try again.");
                    return null;
                } else if (cDistance < 0) {
                    System.out.println("You requested something that is outside the length of the data try again.");
                    return null;
                } else if (row > getMArrayRowLength() || column > getMArrayColumnLength()) {
                    System.out.println("You requested something outside the length of the code");
                    return null;
                }
                mList.add(list);
                inLineRow++;
            }
            if (mList.stream().flatMap(List::stream).allMatch(element -> element.equals(mList.getFirst().getFirst()))) {
                return mList.getFirst().getFirst().getType();
            } else {
                return "Multi";
            }
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

