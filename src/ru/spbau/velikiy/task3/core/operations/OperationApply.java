package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

/**
 * Meta operation. Represent execution of function
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */

public class OperationApply extends Tree {

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars
     * @return expression evaluated evaluate
     * @throws ParserEvaluationException if error is occurred
     */
    public int evaluate(EvaluationContext context) throws ParserEvaluationException {

        String functionName = this.left.getVarName();
        int argValue = right.evaluate(context);
        return context.evalFunction(functionName, argValue);

    }

}