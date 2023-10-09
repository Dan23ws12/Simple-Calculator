package UI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton implements ActionListener {
    private final int buttonNum;
    private final CalculatorController controller;

    public NumberButton(int num, CalculatorController controller){
        super(String.valueOf(num));
        this.buttonNum = num;
        this.controller = controller;
        setFocusable(false);
        this.addActionListener(this);
    }

    public int getNumber(){
        return buttonNum;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addNumber(buttonNum);
    }
}
