package UI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalButton extends JButton implements ActionListener {
    private final CalculatorController controller;

    public DecimalButton(CalculatorController controller){
        super(".");
        this.controller = controller;
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addDecimal();
    }
}
