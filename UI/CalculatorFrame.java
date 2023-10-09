package UI;

import Controller.CalculatorController;
import Model2.*;

import javax.swing.*;
import java.awt.*;
/*
* A class representing the UI or the view of the calculator
* It contains the TextField that hold the output and the panels containing the buttons that serve as
* input
* */
public class CalculatorFrame extends JFrame {
    private final OutputTextField output;
    private CalculatorController controller;
    public CalculatorFrame(CalculatorController controller){
        this.controller = controller;
        output = new OutputTextField();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 550);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.setVisible(true);
        this.setupOutputPanel();
        this.setupValueButtonPanel();
        this.setupSpecialButtonPanel();
    }

    /*
    *
    * */
    private void setupOutputPanel(){
        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.DARK_GRAY);
        outputPanel.setLayout(new FlowLayout());
        outputPanel.setBounds(90, 40, 280, 30);
        outputPanel.add(output);
        this.add(outputPanel);
    }
    /*
    * sets up/creates the panel with the numbers and operators
    * */
    private void setupValueButtonPanel(){
        JPanel valueButtonPanel = new JPanel();
        valueButtonPanel.setBounds(120, 140, 230,240);
        valueButtonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        OperatorButton[] opButtons = new OperatorButton[4];
        opButtons[0] = new OperatorButton(new Multiplication(), controller);
        opButtons[1] = new OperatorButton(new Addition(), controller);
        opButtons[2] = new OperatorButton(new Subtraction(), controller);
        opButtons[3] = new OperatorButton(new Division(), controller);
        for (int i = 0; i <= 3; i ++){
            for (int j = i + 1; j < i + 4; j ++){
                valueButtonPanel.add(new NumberButton((j % 10), controller));
            }
            valueButtonPanel.add(opButtons[i]);
        }
        valueButtonPanel.setBackground(Color.DARK_GRAY);
        this.add(valueButtonPanel);
    }
    /*
    * sets up /creates the panel with buttons that have special functions
    * */
    private void setupSpecialButtonPanel(){
        JPanel specialButtonPanel = new JPanel();
        specialButtonPanel.setBounds(140, 440, 200, 30);
        specialButtonPanel.setLayout(new FlowLayout());
        specialButtonPanel.setBackground(Color.DARK_GRAY);
        specialButtonPanel.add(new DecimalButton(controller));
        specialButtonPanel.add(new JButton("DEL"));
        specialButtonPanel.add(new ClearButton(controller));
        this.add(specialButtonPanel);
    }

    public void setOutput(Expression e, String st){
        output.setOutput(e, st);
    }

    public  void displayError(Exception e){
        output.showException(e);
    }
}
