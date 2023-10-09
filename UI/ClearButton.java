package UI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends JButton implements ActionListener {

    private final CalculatorController controller;

    public ClearButton(CalculatorController controller){
        super("CLR");
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.clear();
    }
}
