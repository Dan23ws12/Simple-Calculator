package UI;
import Controller.CalculatorController;
import Interfaces.Visitable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButton extends JButton implements ActionListener {
    private final CalculatorController control;

    public DeleteButton(CalculatorController control){
        super();
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
