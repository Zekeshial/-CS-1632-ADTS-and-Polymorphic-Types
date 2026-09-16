package edu.umn.d.cs1632;

public class DoubleValue extends Value<Double>{

    public DoubleValue(Double doubleValue) {
        super(doubleValue);
    }




    public DoubleValue(String doubleValueAsString) {
        super(Double.valueOf(doubleValueAsString));
    }

    public DoubleValue() {
        super(0.0);
    }

    @Override
    public Double valueConverter() {
        return Double.valueOf(value);
    }

    @Override
    public String getType() {
        return "Double";
    }
}
