package spbau.velikiy.task3.core;


public class OperationConstant extends Tree{
    
    private final int value;
    
    public OperationConstant(int item, char[] s, int pointer){
        
        this.value = item;
                
    }
        
    
    public OperationConstant(int value){
        this.value = value;        
    }
    
    public int value(int xValue){
        
        return value;

    }

}