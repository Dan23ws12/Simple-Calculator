package Model2;


import java.util.ArrayList;
/*
* This class represents the operators or functions that manipulate values to
* get other values.
* Each operator has a function (a lambda function that does the calculation)
* */
public class Operation implements Expression{

    private final String symbol; // a symbol representing the operation eg * for multiplication
    private ArrayList<Expression> arguments;

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

    public String getSymbol(){
        String symbolString;
        if (arguments.isEmpty()){
            return symbol;
        }
        symbolString = arguments.get(0).getSymbol().concat(symbol);
        for (int i = 1; i < arguments.size(); i ++){
            symbolString = symbolString.concat(arguments.get(i).getSymbol());
        }
        return symbolString;
    }

    @Override
    public Expression evaluate() throws InvalidExpressionException {
        Double val = evaluateFunction(evaluateArguments());
        return new Value(val);
    }

    protected Double evaluateFunction(ArrayList<Double> arr){
        return 0.0;
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
        if (arguments.size() < numNeededArgs){
            this.arguments.add(arg);
        }
    }
    /*
    * removes the argument at the given index
    * does nothing if index is less than zero or greater than or equal to array size
    * */
    public void removeArgument(int index) {
        if ( (index >= 0) && (index < arguments.size())) {
            arguments.remove(index);
        }
    }
}
