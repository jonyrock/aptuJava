package spbau.velikiy.task3.core;

public interface ValueAble<T extends ExpressionType> {

    ExpressionType value(ExpressionType xValue);

}
