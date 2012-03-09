package spbau.velikiy.task3.core;

public class OperationDivision<T extends ExpressionType> extends Tree<T> {

    public ExpressionType value(ExpressionType xValue){       
        return left.value(xValue).division(right.value(xValue).getValue());
    }

}