package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationApply extends Tree {

    public int value(EvaluationContext context) throws ParserEvaluationException {

        String functionName = this.left.getVarName();
        int argValue = right.value(context);
        return context.evalFunction(functionName, argValue);

    }

}