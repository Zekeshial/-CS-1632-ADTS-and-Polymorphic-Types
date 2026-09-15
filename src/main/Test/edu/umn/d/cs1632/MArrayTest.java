package edu.umn.d.cs1632;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MArrayTest {

    @Test
    void getMArrayValue() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.getMArrayValue(4,4);
        String expected = "v2";

        assertEquals(expected, result);

    }

    @Test
    void getMArrayValue2() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.getMArrayValue(4,5);
        String expected = "4";

        assertEquals(expected, result);

    }

    @Test
    void getMArrayValue3() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.getMArrayValue(10,4);
        String expected = null;

        assertEquals(result, expected);

        });

    }

    @Test
    void getMArrayValue4() {
        MArray data = new MArray("src/data/simple.csv");
        String result = data.getMArrayValue(10,4);


        assertThrows(IllegalArgumentException.class, () -> {
            data.getMArrayValue(10,4);
        });

    }
}