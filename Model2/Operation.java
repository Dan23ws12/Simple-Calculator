package Model2;


import java.util.ArrayList;
/*
* This class represents the operators or functions that manipulate values to
* get other values.
* Each operator has a function (a lambda function that does the calculation)
* */
public class Operation implements Expression{

    private final String symbol; // a symbol representing the operation eg * for multiplication
    private final ArrayList<Expression> arguments;

    protected final int numNeededArgs; // the number of parameters necessary to complete the operation

    @Override
    public boolean isLeaf(){
        return false;
    }

    public Operation(String symbol, int numNeededArgs){
        this.numNeededArgs = numNeededArgs;
        this.symbol = symbol;
        this.arguments = new ArrayList<>();
    }
    @Override
    public Double getValue() {
        return null;
    }

    /*
    * Returns a string symbol representing an operation.
    * e.g. if argument is 1, Addition symbol is "1 +"
    * */
    public String getSymbol(){
        String symbolString;
        if (arguments.isEmpty()){
            return symbol;
        }
        symbolString = this.getArgumentSymbol(arguments.get(0)).concat(symbol);
        for (int i = 1; i < arguments.size(); i ++){
            symbolString = symbolString.concat(this.getArgumentSymbol(arguments.get(i)));
        }
        return symbolString;
    }

    /**
     * Returns the Value object containing the value that is the evaluation of the expression
     * E.g. If arguments are 2 and 2, Multiplication returns Value object containing 4.0
     * */
    @Override
    public Expression evaluate() throws InvalidExpressionException {
        Double val = evaluateFunction(evaluateArguments());
        return new Value(val);
    }

    /*
    * This function performs the calculation on the values from the arguments of this expression.
    * Only is called when expression is valid
    * */
    protected Double evaluateFunction(ArrayList<Double> ignoredArr){
        return 0.0;
    }
    /*
    * returns _ if an argument is null
    * otherwise returns argument's symbol
    * */
    private String getArgumentSymbol(Expression e){
        if (e == null){
            return "_";
        }
        return e.getSymbol();
    }

    /*
    * This function evaluates all the expressions, making sure all the arguments
    * evaluate to values or the expression is invalid and returns a list of
    * all the values gotten in (first in first out order or FIFO)
    * */
    protected ArrayList<Double> evaluateArguments() throws InvalidExpressionException {
        ArrayList<Double> numbers = new ArrayList<>();
        if ((this.arguments.isEmpty()) || (arguments.size() != numNeededArgs)){
            throw new InvalidExpressionException();
        }
        for(Expression arg: this.arguments){
            if (arg == null){
                throw new InvalidExpressionException();
            }
            Double value = arg.evaluate().getValue();
            if (value == null){
                throw new InvalidExpressionException();
            }
            numbers.add(value);
        }
        return numbers;
    }

    public ArrayList<Expression> getArguments(){
        return arguments;
    }
    /*
    * adds an argument to the list of arguments if list isn't already full
    * */
    public void addArgument(Expression arg){
        this.arguments.add(arg);
    }
    /*
    * removes the last argument in argument array
    * does nothing if argument array is empty
    * */
    public Expression removeLastArgument() {
        if (!arguments.isEmpty()) {
            return arguments.remove(arguments.size() - 1);
        }
        return null;
    }
}
