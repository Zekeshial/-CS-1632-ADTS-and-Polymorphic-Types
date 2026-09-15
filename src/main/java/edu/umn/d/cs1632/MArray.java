package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

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

    public String getMArrayValue(int targetRow, int targetColumn) throws IllegalArgumentException{
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            if (targetRow < allData.size()) {
                String[] row = allData.get(targetRow);
                if (targetColumn < row.length) {
                    return row[targetColumn];
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


}

