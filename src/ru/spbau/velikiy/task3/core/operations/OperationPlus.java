package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationPlus extends Tree {

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant value
     * @throws ParserEvaluationException if error is occurred
     */
    public int value(EvaluationContext context) throws ParserEvaluationException {
        return left.value(context) + right.value(context);
    }

}