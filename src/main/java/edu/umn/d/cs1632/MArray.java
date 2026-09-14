package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private MArray() {}
    public MArray(String fileName) {
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
}
