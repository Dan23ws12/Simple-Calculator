package UI;

import Controller.CalculatorController;
import Model2.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends JButton implements ActionListener {
    private final Operation op;
    private final CalculatorController controller;
    public OperatorButton(Operation op, CalculatorController controller){
        super(op.getSymbol());
        this.controller = controller;
        this.op = op;
        this.addActionListener(this);
    }

    public Operation getOperation(){
        return op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addOperation(op);
    }
}
