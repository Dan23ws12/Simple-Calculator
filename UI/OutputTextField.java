package UI;

import Model2.Expression;
import Model2.Value;

import javax.swing.*;
import java.awt.*;

public class OutputTextField extends JTextField {

    public OutputTextField(){
        super();
        this.setEditable(false);
        this.setPreferredSize(new Dimension(260, 25));
    }

    /*
    *
    * */
    public void setOutput(Expression expr, String numString, boolean isDecimalNumber){
        if (expr != null){
            if((expr.isLeaf() && (isDecimalNumber)) || !expr.isLeaf()){
                this.setText(expr.getSymbol().concat(numString));
            }
            else if (numString.isBlank()){// if expression is a Value object and number is not a decimal
                Value val = (Value) expr;
                this.setText(String.format("%f", val.getValue()));
            }
            else {
                Value val = (Value) expr;
                Double db = (val.getValue() + Double.parseDouble(numString));
                this.setText(String.format("%f", val.getValue() + db));
            }
        }else {
            this.setText(numString);
        }
    }
    /*
    * this function is called when an exception occurs (usually the exception is InvalidException
    * or DivideByZeroException) and displays the error message
    * */
    public void showException(Exception e){
        this.setText(e.toString());
    }
}
