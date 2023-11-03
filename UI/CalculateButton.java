package UI;

import Controller.CalculatorController;

import java.awt.event.ActionEvent;
/*
* This class represents the button that tells the calculator to evaluate the current expression
* */
public class CalculateButton extends SpecialButton{

    public CalculateButton(CalculatorController controller) {
        super(controller);
        this.setText("=");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getController().calculate();
    }
}
