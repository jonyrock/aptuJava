package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationDivision extends Tree {

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant calculateValue
     * @throws ParserEvaluationException if error is occurred
     */
    public int calculateValue(EvaluationContext context) throws ParserEvaluationException {

        // lazy evaluation
        int leftValue = left.calculateValue(context);
        if (leftValue == 0)
            return 0;

        return leftValue / right.calculateValue(context);
    }

}