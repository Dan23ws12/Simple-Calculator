package Controller;

import Model2.Expression;
import Model2.Operation;
import Model2.Value;
import UI.CalculatorView;


/*
* This class controls the UI and keeps track of the calculation the user is trying to perform.
* This class has a:
* String which is numString that should only contain numbers and 1 dot
* (in the case the number is a decimal).
* Variable that is the length of numString which is numberLn.
* Variable which is isDecimalNum that is true if the number stored in numString is decimal (already has a dot),
* false otherwise, at first it is always false.
* Variable containing the last expression put in by the user
* */
public class CalculatorController {
    private final CalculatorView frame;

    private String numString; // the number being input but in string form

    private int numberLn;
    private boolean isDecimalNum;    // is true if the number in numString is a decimal number
    private Expression currExpression;
    public CalculatorController(){
        resetNumString();
        this.frame = new CalculatorView(this);
    }

    /**
     * Adds a number to the end of numString
     * */
    public void addNumber(int num){
        numString = numString.concat(String.format("%d",num));
        numberLn +=1;
        frame.displayExpression(currExpression, numString, isDecimalNum);
    }

    /**
     * This function is called when a decimal button is pushed.
     * If the numString empty, creates the numString = 0.0.
     * Does nothing if the number in numString is a decimal number, if not adds a dot to end of numString and
     * turns isDecimalNum to true.
     * */
    public void addDecimal(){
        if (!isDecimalNum){
            if ("".equals(numString)){
                numString = "0";
                numberLn +=1;
            }
            numString = numString.concat(".");
            numberLn += 1;
            isDecimalNum = true;
            frame.displayExpression(currExpression, numString, true);
        }
    }

    /*
    * This function makes the numString empty, and sets isDecimal = false
    * */
    private void resetNumString(){
        isDecimalNum = false;
        numString = "";
        numberLn = 0;
    }

    /*
    * makes the expression and number string empty
    * */
    private void resetAll(){
        resetNumString();
        this.currExpression = null;
    }

    /*
    * resets the expression and numString, also displays that the expression has been reset on the UI
    * */
    public void clear(){
        resetAll();
        frame.displayExpression(null, numString, isDecimalNum);
    }

    /*
    * returns true if the given expression is empty (expression is null), returns false otherwise
    * */
    private boolean isExpressionEmpty(Expression expression){
        return (expression == null);
    }

    /*
    * This function does nothing if numString is empty (no number in numString)
    * If the current expression is an Operation, then this function adds the number is numString as a
    * Value object to the list of arguments of the current expression.
    * If current expression is empty, makes a Value object containing the number in numString the current expression
    * If current expression is a Value, adds number in numString to the value contained in the current expression and
    * makes the result the current expression
    * */
    private void addNumArgToCurrExpression(){
        if (!numString.isBlank()){ // should no nothing if number argument is empty
            Double numToBeAdded = Double.parseDouble(numString);
            if ((isExpressionEmpty(this.currExpression))){
                currExpression = new Value(numToBeAdded);
            }
            else if (currExpression.isLeaf()){ // if currExpression is a Value object
                currExpression = new Value(Double.parseDouble(numString) + currExpression.getValue());
            }
            else {
                Operation op = (Operation) currExpression;
                op.addArgument(new Value(numToBeAdded));
                currExpression = op;
            }
            this.resetNumString();
        }
    }
    /*
    * This function calculates and displays the value of the calculator's expression, shows
    * appropriate error if expression is invalid
    * */
    public void calculate(){
        try {
            addNumArgToCurrExpression();
            currExpression = currExpression.evaluate();
            frame.displayExpression(currExpression, numString, isDecimalNum);
        }catch (Exception e){
            frame.displayError(e);
            resetAll();
        }
    }

    /*
    * Works like a calculator delete button.
    * If the argument last entered was a number, this function removes the last digit of that number
    * or decimal point if last entered was decimal point.
    * If the argument last entered was an operation, removes the operation, otherwise does nothing
    * Always reset's the numString and numString related variables (numberLn and isDecimalNum)
    * */
    public void delete(){
        if (!numString.isBlank()){ // checks if the numberArgument is empty
            String lastChar = String.format("%c", numString.charAt(Math.min(0, numberLn - 2)));
            numString = numString.substring(0, Math.min(0, numberLn - 2));
            if (".".equals(lastChar)){ // if decimal point is removed number no longer is a decimal
                isDecimalNum = false;
            }
            numberLn -=1;
        }
        if (!isExpressionEmpty(currExpression)){
            if (currExpression.isLeaf()){
                numString = String.format("%f", currExpression.getValue());
                currExpression = null;
            }
            else{
                Operation op = (Operation) currExpression;
                currExpression = op.removeLastArgument();
            }
        }
        frame.displayExpression(currExpression, numString, isDecimalNum);
    }

    /**
     * This function makes the value of the current expression's evaluation an argument in the op argument
     * and makes the op the current expression
     * */
    public void addOperation(Operation op){
        if (!isExpressionEmpty(op)){
            try{
                this.addNumArgToCurrExpression();
                currExpression = currExpression.evaluate();
                op.addArgument(currExpression);
                currExpression = op;
                frame.displayExpression(currExpression, numString, isDecimalNum);
            }catch (Exception e){
                frame.displayError(e);
                resetAll();
            }
        }
    }
}
