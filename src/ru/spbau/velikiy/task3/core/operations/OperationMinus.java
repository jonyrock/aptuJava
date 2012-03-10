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
     * @return constant calculateValue
     * @throws ParserEvaluationException if error is occurred 
     */
    public int calculateValue(EvaluationContext context) throws ParserEvaluationException {

        // if it is unary minus
        if (left == null) {
            return -right.calculateValue(context);
        }

        // otherwise it is binary
        return left.calculateValue(context) - right.calculateValue(context);

    }

}