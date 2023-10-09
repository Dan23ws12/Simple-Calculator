package UI;

import Model2.Expression;

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
    public void setOutput(Expression expr, String numString){
        if (expr != null){
            this.setText(expr.getSymbol().concat(numString));
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
