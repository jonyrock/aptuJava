package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;

public class OperationMinus extends Tree {

    public int value(EvaluationContext context) {
        
        // if it is unary minus
        if(left == null){
            return -right.value(context);
        }
        
        // otherwise it is binary
        return left.value(context) - right.value(context);
        
    }

}