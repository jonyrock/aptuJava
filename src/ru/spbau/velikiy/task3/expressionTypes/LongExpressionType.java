package spbau.velikiy.task3.expressionTypes;

import spbau.velikiy.task3.core.ExpressionType;

public class LongExpressionType implements ExpressionType<Long> {
    
    private Long value;
    public LongExpressionType(Long value){
        this.value = value;
    }
    
    public Long getValue(){
        return value;
        
    }   

    
    public LongExpressionType plus(Long b){
        return new LongExpressionType(this.value + b);
    }
    
    public LongExpressionType minus(Long b){
        return  new LongExpressionType(this.value - b);  
    }
    
    public LongExpressionType division(Long b){
        return new LongExpressionType(this.value / b);
    }
    
    public LongExpressionType multiplication(Long b){
        return new LongExpressionType(this.value * b);
    }
    
    public void valueByString(char[] expressionString, int pointer) {

        long res = 0;

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
    
    public LongExpressionType copy(){        
        return new LongExpressionType(this.value);        
    }  
    
    
    public static LongExpressionType getDefault(){        
        return new LongExpressionType(0l);        
    }
    
    
}
