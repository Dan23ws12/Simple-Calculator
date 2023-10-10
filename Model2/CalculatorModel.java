package Model2;

import UI.CalculatorFrame;

public class CalculatorModel {

    private String arg; // the number being input but in string form
    private boolean isDecimal;
    private Expression currExpression;
    private int argLn;
    private final CalculatorFrame frame;

    public CalculatorModel(CalculatorFrame frame){
        this.arg = "";
        this.isDecimal = false;
        this.argLn = 0;
        this.frame = frame;
    }

    public void clear(){
        this.resetNumberArgument();
        currExpression = null;
        frame.setOutput(null, arg);
    }

    private void resetNumberArgument(){
        isDecimal = false;
        arg = "";
        argLn = 0;
    }

    public void calculate() throws InvalidExpressionException {
        if ((currExpression == null) && !arg.isEmpty()){
            currExpression = new Value(Double.parseDouble(arg));
            this.resetNumberArgument();
        }else if (currExpression != null){
            currExpression = currExpression.evaluate();
        }
        frame.setOutput(currExpression, arg);
    }

    public void addDecimal(){
        if (!isDecimal){
            if ("".equals(arg)){
                arg = "0";
                argLn += 1;
            }
            arg = arg.concat(".");
            argLn +=1;
            isDecimal = true;
            frame.setOutput(currExpression, arg);
        }
    }
    /**/
    public void addNumber(int num){
        if (currExpression == null){
            arg = arg.concat(String.valueOf(num));
        }
        else if (currExpression.isLeaf()){
            currExpression = new Value(currExpression.getValue() + num);
        }
        else{
            arg = arg.concat(String.valueOf(num));
        }
        argLn +=1;
        frame.setOutput(currExpression, arg);
    }
    /*
    *
    * */
    public void addOperation(Operation op){
        if (currExpression == null){
            if (!arg.isEmpty()){
                op.addArgument(new Value(Double.parseDouble(arg)));
            }
            else {
                op.addArgument(null);
            }
            currExpression = op;
            this.resetNumberArgument();
        }
        else if (currExpression.isLeaf()){
            if (!arg.isEmpty()){
                currExpression = new Value(currExpression.getValue() + Double.parseDouble(arg));
            }
            op.addArgument(currExpression);
            this.resetNumberArgument();
        }
        else if (!arg.isEmpty()){
            Operation op2 = (Operation) currExpression;
            op2.addArgument(new Value(Double.parseDouble(arg)));
            op.addArgument(op2);
            this.resetNumberArgument();
        }
        else {
            op.addArgument(currExpression);
        }
        currExpression = op;
        frame.setOutput(currExpression, arg);
    }
}
