package UI;

import Controller.CalculatorController;

import java.awt.event.ActionEvent;

/*
 * This class represents the button that tells the calculator to add a decimal point to the number being entered
 * */
public class DecimalButton extends SpecialButton{
    public DecimalButton(CalculatorController controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getController().addDecimal();
    }
}
