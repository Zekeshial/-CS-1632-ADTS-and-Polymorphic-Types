package edu.umn.d.cs1632;

public class IntValue extends Value<Integer>{

    public IntValue(Integer intValue) {
        super(intValue);
    }




    public IntValue(String IntValueAsString) {
        super(Integer.valueOf(IntValueAsString));
    }

    @Override
    public Integer valueConverter() {
        return Integer.valueOf(value);
    }

    @Override
    public String getType() {
        return "Integer";
    }

}
