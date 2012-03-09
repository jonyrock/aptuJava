package spbau.velikiy.task3;

import spbau.velikiy.task3.core.ExpressionsTreeParser;
import spbau.velikiy.task3.expressionTypes.*;

public class Main {
        
    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println("Bad params\nExample: calc -f \"(15.9 + 12.9) * x + 20\"");
            System.exit(1);
        }
        
        if (args[0].length() == 0) {
            System.out.println("Bad expression");
            System.exit(1);
        }
               
        switch (args[0].charAt(1)) {
            case 'i':IntegerCase(args[1]);break;
            case 'l':LongCase(args[1]);break;
            case 'f':FloatCase(args[1]);break;
            case 'd':DoubleCase(args[1]);break;
            default:
               IntegerCase(args[0]); 
        }                
        
    }
    
    private static void IntegerCase(String expression){        
        ExpressionsTreeParser e = 
                new ExpressionsTreeParser<IntegerExpressionType>(expression, IntegerExpressionType.getDefault());
        for(int i = 0; i < 10; i++){
            System.out.println(e.getValue(new IntegerExpressionType(i)).getValue());
        }
    }
    
    private static void LongCase(String expression){        
        ExpressionsTreeParser e = 
                new ExpressionsTreeParser<LongExpressionType>(expression, LongExpressionType.getDefault());
        for(long i = 0; i < 10; i++){
            System.out.println(e.getValue(new LongExpressionType(i)).getValue());
        }
    }
    
    private static void FloatCase(String expression){        
        ExpressionsTreeParser e = 
                new ExpressionsTreeParser<FloatExpressionType>(expression, FloatExpressionType.getDefault());
        for(float i = 0; i < 10; i++){
            System.out.println(e.getValue(new FloatExpressionType(i)).getValue());
        }
    }
    
    private static void DoubleCase(String expression){        
        ExpressionsTreeParser e = 
                new ExpressionsTreeParser<DoubleExpressionType>(expression, DoubleExpressionType.getDefault());
        for(double i = 0; i < 10; i++){
            System.out.println(e.getValue(new DoubleExpressionType(i)).getValue());
        }
    }
    
}
