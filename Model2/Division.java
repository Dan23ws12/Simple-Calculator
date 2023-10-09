package Model2;

import java.util.ArrayList;

public class Division extends Operation{

    public Division() {
        super("/", 2);
    }

    public Double evaluationFunction(ArrayList<Double> arr){
        return arr.get(0) / arr.get(1);
    }

    @Override
    public Expression evaluate() throws InvalidExpressionException {
        return new Value(this.evaluationFunction(super.evaluateArguments()));
    }

    @Override
    protected ArrayList<Double> evaluateArguments() throws InvalidExpressionException {
        ArrayList<Double> numbers = new ArrayList<>();
        if ((this.getArguments().isEmpty()) || (this.getArguments().size() != this.numNeededArgs)){
            throw new InvalidExpressionException();
        }
        for(int i = 0; i < numNeededArgs; i ++){
            Expression arg = this.getArguments().get(i);
            if (arg == null){
                throw new InvalidExpressionException();
            }
            Double value = arg.evaluate().getValue();
            if ((value == null) || ((i == 1) && (value == 0))){
                //if second value is null or 0 throw exception
                throw new InvalidExpressionException();
            }
            numbers.add(value);
        }
        return numbers;
    }
}
