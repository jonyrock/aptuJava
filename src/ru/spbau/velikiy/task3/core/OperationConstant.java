package spbau.velikiy.task3.core;


public class OperationConstant<T extends ExpressionType> extends Tree<T> {
    
    private final ExpressionType value;
    
    public OperationConstant(T item, char[] s, int pointer){
        this.value = item.copy();
        this.value.valueByString(s, pointer);
    }
        
    
    public OperationConstant(T value){
        this.value = value;        
    }
    
    public ExpressionType value(ExpressionType xValue){
        
        return value;

    }

}