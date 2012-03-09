package spbau.velikiy.task3;

import spbau.velikiy.task3.core.ExpressionsTreeParser;
import spbau.velikiy.task3.expressionTypes.*;

import java.io.FileReader;

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

        
//        ExpressionsTreeParser e =
//                new ExpressionsTreeParser<IntegerExpressionType>(expression, IntegerExpressionType.getDefault());
//        for(int i = 0; i < 10; i++){
//            System.out.println(e.getValue(new IntegerExpressionType(i)).getValue());
//        }
        
    }
    
    
    
   
    
}
