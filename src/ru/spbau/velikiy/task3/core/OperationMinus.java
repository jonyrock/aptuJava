package spbau.velikiy.task3.core;

public class OperationMinus<T extends ExpressionType> extends Tree<T> {

    public ExpressionType value(ExpressionType xValue){       
        return left.value(xValue).minus(right.value(xValue).getValue());
    }

}