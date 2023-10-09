package Model2;

import Model2.Expression;

/*
* Represents the leaf of an expression tree
* This class contains a (non-null) value
* */
public class Value implements Expression {
    // the value in string form
    private final String symbol;
    private final Double value;

    public Value(Double value){
        this.symbol = String.format("%f", value);
        this.value = value;
    }
    @Override
    public Double getValue() {
        return value;
    }
    //returns the value in string form
    public String getSymbol(){
        return symbol;
    }
    /*
    * evaluates the Value expression, returns self
    * */
    @Override
    public Expression evaluate() {
        return this;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
