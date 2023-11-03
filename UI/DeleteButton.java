package UI;

import Controller.CalculatorController;

import java.awt.event.ActionEvent;

/*
* This class represents the button that tells the calculator to delete the last digit or last entered operation
* depending on the situation
* */
public class DeleteButton extends SpecialButton{
    public DeleteButton(CalculatorController controller){
        super(controller);
        this.setText("DEL");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getController().delete();
    }


}
