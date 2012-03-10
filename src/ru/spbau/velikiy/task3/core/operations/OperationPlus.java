package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationPlus extends Tree {

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant evaluate
     * @throws ParserEvaluationException if error is occurred
     */
    public int evaluate(EvaluationContext context) throws ParserEvaluationException {
        return left.evaluate(context) + right.evaluate(context);
    }

}