package edu.umn.d.cs1632;

public abstract class Value {
    protected String stringvalue;

    public Value(String stringvalue) {
        this.stringvalue = stringvalue;
    }

    public String getStringvalue() {
        return stringvalue;
    }

    public void setStringvalue(String stringvalue) {
        this.stringvalue = stringvalue;
    }

    public abstract void ValueConverter ();

}
