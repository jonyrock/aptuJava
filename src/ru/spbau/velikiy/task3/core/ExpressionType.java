package spbau.velikiy.task3.core;

public interface ExpressionType<T> {
    
    T getValue();    

    ExpressionType<T> plus(T b);
    ExpressionType<T> minus(T b);
    ExpressionType<T> division(T b);
    ExpressionType<T> multiplication(T b);        
    
    ExpressionType<T> copy();
    
    void valueByString(char[] expressionString, int pointer);
    
    
}
