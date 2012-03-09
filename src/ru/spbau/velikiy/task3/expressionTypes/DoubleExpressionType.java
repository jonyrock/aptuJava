package spbau.velikiy.task3.expressionTypes;

import spbau.velikiy.task3.core.ExpressionType;

public class DoubleExpressionType implements ExpressionType<Double> {
    
    private Double value;
    public DoubleExpressionType(Double value){
        this.value = value;
    }
    
    public Double getValue(){
        return value;
        
    }   
    
    public DoubleExpressionType plus(Double b){        
        return new DoubleExpressionType(this.value + b);
    }
    
    public DoubleExpressionType minus(Double b){        
        return new DoubleExpressionType(this.value - b);
    }
    
    public DoubleExpressionType division(Double b){        
        return new DoubleExpressionType(this.value / b); 
    }
    
    public DoubleExpressionType multiplication(Double b){        
        return new DoubleExpressionType(this.value * b); 
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
        
        this.value = Double.parseDouble(b.toString());
        
    }
        
    public DoubleExpressionType copy(){        
        return new DoubleExpressionType(this.value);        
    }  
    
    
    public static DoubleExpressionType getDefault(){        
        return new DoubleExpressionType(0d);        
    }
    
    
}
