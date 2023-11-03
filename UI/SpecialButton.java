package UI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
* A class representing the buttons that cause the controller to perform special functions
* like calculate, delete, decimal, clear
* */
public class SpecialButton extends JButton implements ActionListener {

    private final CalculatorController controller;
    public SpecialButton(CalculatorController controller){
        this.controller = controller;
        this.addActionListener(this);
        this.setPreferredSize(new Dimension(60, 30));
    }

    public CalculatorController getController(){
        return controller;
    }

    /*
    * */
    @Override
    public void actionPerformed(ActionEvent e){

    }


}
