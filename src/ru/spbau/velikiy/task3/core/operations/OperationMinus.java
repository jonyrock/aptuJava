package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

/**
 * Implements munis operation
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public class OperationMinus extends Tree {

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant evaluate
     * @throws ParserEvaluationException if error is occurred 
     */
    public int evaluate(EvaluationContext context) throws ParserEvaluationException {

        // if it is unary minus
        if (left == null) {
            return -right.evaluate(context);
        }

        // otherwise it is binary
        return left.evaluate(context) - right.evaluate(context);

    }

}