package UI;

import Controller.CalculatorController;

import java.awt.event.ActionEvent;

/*
 * This class represents the button that tells the calculator to reset the expression on screen
 * */
public class ClearButton extends SpecialButton{

    public ClearButton(CalculatorController controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getController().clear();
    }
}
