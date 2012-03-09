package spbau.velikiy.task3.expressionTypes;

import spbau.velikiy.task3.core.ExpressionType;

public class FloatExpressionType implements ExpressionType<Float> {
    
    private Float value;
    public FloatExpressionType(Float value){
        this.value = value;
    }
    
    public Float getValue(){
        return value;
        
    }   

    
    public FloatExpressionType plus(Float b){              
        return new FloatExpressionType(this.value + b);
    }
    
    public FloatExpressionType minus(Float b){
        return new FloatExpressionType(this.value - b); 
    }
    
    public FloatExpressionType division(Float b){
        return new FloatExpressionType(this.value / b);
    }
    
    public FloatExpressionType multiplication(Float b){
        return new FloatExpressionType(this.value * b); 
    }
    
    public void valueByString(char[] expressionString, int pointer) {
        
        StringBuilder b = new StringBuilder();
        
        for(; pointer != expressionString.length; pointer++ ) {

            char t = expressionString[pointer];
            if (!(Character.isDigit(t) || expressionString[pointer] == '.')) {                
                break;
            }
            b.append(expressionString[pointer]);
        }
        
        this.value = Float.parseFloat(b.toString());
        
    }
    
    public FloatExpressionType copy(){        
        return new FloatExpressionType(this.value);        
    }  
    
    
    public static FloatExpressionType getDefault(){        
        return new FloatExpressionType(0f);        
    }
    
    
}
