package Model2;

import java.util.ArrayList;

public class Addition extends Operation{

    public Addition() {
        super("+", 2);
    }

    public Double evaluationFunction(ArrayList<Double> arr){
        return arr.get(0) + arr.get(1);
    }
    @Override
    public Expression evaluate() throws InvalidExpressionException {
        return new Value(this.evaluationFunction(super.evaluateArguments()));
    }

}