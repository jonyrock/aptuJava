package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;

public class OperationApply extends Tree {

    public int value(EvaluationContext context) {

        String functionName = this.left.getVarName();
        int argValue = right.value(context);
        return context.evalFunction(functionName, argValue);

    }

}