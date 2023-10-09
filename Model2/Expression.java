package Model2;

/*
* An interface defining an Model2.Expression
* It is supposed to be a Composite design with Values as leaves
* and Operators as nodes
* getValue() returns a Double
* null if expression is an operator
* A number if the expression is a value
* values can also be gotten from the evaluation of an operator
* evaluate() returns the value gotten by evaluating a valid expression,
* if no such value exists (evaluates to a function) throws an exception
* */
public interface Expression {
    public Double getValue();
    public Expression evaluate() throws InvalidExpressionException;

    public String getSymbol();
    public boolean isLeaf();
}
