package spbau.velikiy.task3.core;

public class OperationMultiplication<T extends ExpressionType> extends Tree<T> {

    public ExpressionType value(ExpressionType xValue){       
        return left.value(xValue).multiplication(right.value(xValue).getValue());
    }

}
