package spbau.velikiy.task3.core;


public class OperationConstant extends Tree{
    
    private final int value;
    
    public OperationConstant(T item, char[] s, int pointer){
        this.value = item.copy();
        
        //this..valueByString(s, pointer);
    }
        
    
    public OperationConstant(T value){
        this.value = value;        
    }
    
    public ExpressionType value(ExpressionType xValue){
        
        return value;

    }

}