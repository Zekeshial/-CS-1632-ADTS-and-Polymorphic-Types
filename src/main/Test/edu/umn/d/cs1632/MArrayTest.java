package edu.umn.d.cs1632;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MArrayTest {

    @Test
    void getMArrayValue() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(4,4);
        String expected = "v2";

        assertEquals(expected, result);

    }

    @Test
    void getMArrayValue2() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(4,5);
        int expected = 4;

        assertEquals(expected, result);

    }

    @Test
    void getMArrayValue3() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(10,4);
        String expected = null;

        assertEquals(result, expected);

    }

    @Test
    void getMArrayValue4() {
        MArray data = new MArray("src/data/simple.csv");
        Value result = data.getMArrayValue(10,4);


        assertThrows(IllegalArgumentException.class, () -> {
            data.getMArrayValue(10,4);
        });

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
    void MArraySubMatrixValuesTest1() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.MArraySubMatrixValues(2,3,5,4);
        String expected = "String";

        assertEquals(expected, result);
    }

    @Test
    void Test() {
        ArrayList<ArrayList<Value>> mList = new ArrayList<>();
        ArrayList<Value> list = new ArrayList<>();
        ArrayList<Value> list2 = new ArrayList<>();

        DoubleValue d = new DoubleValue(4.1);
        IntValue i = new IntValue(5);
        IntValue r = new IntValue(4);
        StringValue s = new StringValue("asd");


        list.add(d);
        list.add(r);
        list2.add(s);
        list2.add(i);

        System.out.println(mList.stream().flatMap(Collection::stream).allMatch(element -> element.equals(mList.getFirst().getFirst())));

    }



}