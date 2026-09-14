package edu.umn.d.cs1632;

public class IntValue extends Value<Integer>{

    public IntValue(Integer intValue) {
        super(intValue);
    }

    public IntValue(String IntValueAsString) {
        super(Integer.valueOf(IntValueAsString));
    }



}
