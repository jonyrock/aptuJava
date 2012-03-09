package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;

public class OperationDivision extends Tree {

    public int value(EvaluationContext context){

        // lazy evaluation
        int leftValue = left.value(context);
        if(leftValue == 0)
            return 0;
        
        return leftValue / right.value(context);
    }

}