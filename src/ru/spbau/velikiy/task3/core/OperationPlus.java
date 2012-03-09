package spbau.velikiy.task3.core;

public class OperationPlus<T extends ExpressionType> extends Tree<T> {

    public ExpressionType value(ExpressionType xValue){       
        return left.value(xValue).plus(right.value(xValue).getValue());
    }

}