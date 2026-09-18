package edu.umn.d.cs1632;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MArrayTest {

    @Test
    void getMArrayValue() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(4,4);
        String expected = "v2";

        assertEquals(expected, result.getValue());

    }

    @Test
    void getMArrayValue2() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(2,4);
        double expected = 4.1;

        assertEquals(expected, result.getValue());

    }

    @Test
    void getMArrayValue3() {
        MArray data = new MArray("src/data/simple.csv");
        String expected = "Your target column is outside the bounds of the data.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {data.getMArrayValue(10,4);});
        String result = exception.getMessage();
        assertEquals(result, expected);

    }


    @Test
    void getMArrayRowLength() {
        MArray data = new MArray("src/data/simple.csv");
        int result = data.getMArrayRowLength();
        int expected = 6;

        assertEquals(expected, result);
    }

    @Test
    void getMArrayColumnLength() {
        MArray data = new MArray("src/data/simple.csv");
        int result = data.getMArrayColumnLength();
        int expected = 7;

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(0,1,4);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest2() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,3,4);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest3() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,1,3);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest4() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,1,0);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest5() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,1,1);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest6() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,1,10);
        String expected = null;

        assertEquals(expected, result);
    }

    @Test
    void MArrayHorizontalValuesTest7() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayHorizontalValues(2,1,-1);
        String expected = null;

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(2,1,3);
        String expected = "Integer";

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest2() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(1,0,4);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest3() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(5,3,1);
        String expected = "Integer";

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest4() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(2,2,5);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest5() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(2,5,2);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArrayVerticalValuesTest6() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArrayVerticalValues(2,2,4);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest1() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(2,3,5,4);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest2() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(2,3,5,5);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest3() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(2,2,5,2);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest4() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(2,2,2,4);
        String expected = "Multi";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest5() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(5,4,0,3);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest6() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(5,4,0,10);
        String expected = null;

        assertEquals(expected, result);
    }

    @Test
    void MArraySubMatrixValuesTest7() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(5,4,10,0);
        String expected = null;

        assertEquals(expected, result);
    }



    @Test
    void Test() {
//        MArray data = new MArray("src/data/simple.csv");
//        int rDistance = 5;
//        int row = 2;
//        int inLineRow = 2;
//        int column = 3;
//        int cDistance = 5;
//        ArrayList<String> itemsToCheck = new ArrayList<>();
//        for (int i = 0; i <= rDistance - row; i++) {
//            itemsToCheck.add(data.MArrayHorizontalValues(inLineRow, column, cDistance));
//            inLineRow++;
//        }
//        System.out.println(itemsToCheck);

    }



}