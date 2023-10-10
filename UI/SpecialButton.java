package UI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
* A class representing the buttons that cause the controller to perform special functions
* like calculate, delete, decimal, clear
* */
public class SpecialButton extends JButton implements ActionListener {
    private final SpecialFunction function;
    private final CalculatorController controller;
    public SpecialButton(SpecialFunction function, CalculatorController controller){
        this.function = function;
        this.controller = controller;
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (function){
            case DECIMAL:
                controller.addDecimal();
                break;
            case CLEAR:
                controller.clear();
                break;

            case CALCULATE:
                controller.calculate();
                break;

            case DELETE:
                controller.delete();
                break;
        }
    }
}
