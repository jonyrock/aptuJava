package spbau.velikiy.task3.core;


public class OperationConstant extends Tree{
    
    private final int value;

    /**
     * 
     * Create constant from source string expression 
     * and pointer in it
     * 
     * @param s source expression
     * @param pointer position in expression
     */
    public OperationConstant(char[] s, int pointer){
        
        this.value = 0;

        //this.value.valueByString(s, pointer);
        
        
        //this.value = 10;


    }
        
    
    public OperationConstant(int value){
        this.value = value;        
    }
    
    public int value(int xValue){
        
        return value;

    }

}