package Interfaces;

import UI.ClearButton;
import UI.DeleteButton;
import UI.NumberButton;
import UI.OperatorButton;

public interface Visitor {
    public void visit(NumberButton button);
    public void visit(OperatorButton button);
    public void visit(DeleteButton button);
    public void visit(ClearButton button);
}

