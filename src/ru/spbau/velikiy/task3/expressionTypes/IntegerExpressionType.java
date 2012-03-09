package spbau.velikiy.task3.expressionTypes;

import spbau.velikiy.task3.core.ExpressionType;

public class IntegerExpressionType implements ExpressionType<Integer> {
    
    private Integer value;
    public IntegerExpressionType(Integer value){
        this.value = value;
    }
    
    public Integer getValue(){
        return value;
        
    }   

    
    public IntegerExpressionType plus(Integer b){
        return new IntegerExpressionType(this.value + b);  
    }
    
    public IntegerExpressionType minus(Integer b){
        return new IntegerExpressionType(this.value - b);
    }
    
    public IntegerExpressionType division(Integer b){
        return new IntegerExpressionType(this.value / b);
    }
    
    public IntegerExpressionType multiplication(Integer b){        
        return new IntegerExpressionType(this.value * b);  
    }
    
    public void valueByString(char[] expressionString, int pointer) {

        int res = 0;

        for(; pointer != expressionString.length; pointer++ ) {

            int t = expressionString[pointer] - '0';
            if (!(t >= 0 && t <= 9)) {
                this.value = res;
                return;
            }
            res = res * 10 + t;

        }

        this.value = res;        
    }
    
    public IntegerExpressionType copy(){
        return new IntegerExpressionType(this.value);
    }
    
    public static IntegerExpressionType getDefault(){        
        return new IntegerExpressionType(0);        
    }
    
    
}
