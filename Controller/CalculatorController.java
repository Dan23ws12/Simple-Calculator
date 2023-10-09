package Controller;

import Model2.CalculatorModel;
import Model2.Operation;
import UI.*;

public class CalculatorController {
    private final CalculatorFrame frame;
    private final CalculatorModel model;
    public CalculatorController(){
        this.frame = new CalculatorFrame(this);
        this.model = new CalculatorModel(frame);
    }

    public void addNumber(int num){
        model.addNumber(num);
    }

    public void addDecimal(){
        model.addDecimal();
    }

    public void clear(){
        model.clear();
    }

    public void calculate(){
        try {
            model.equals();
        }catch (Exception e){
            frame.displayError(e);
        }
    }

    public void addOperation(Operation op){
        model.addOperation(op);
    }
}
