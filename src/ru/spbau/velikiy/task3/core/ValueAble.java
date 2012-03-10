package spbau.velikiy.task3.core;

import spbau.velikiy.task3.exceptions.ParserEvaluationException;

/**
 * Interface for evaluation
 */

public interface ValueAble {

    /**    
     * evaluate expression according to context
     * 
     * @param context definitions of vars
     * @return expression evaluated value
     * @throws ParserEvaluationException if occurred error
     */
    int value(EvaluationContext context) throws ParserEvaluationException;

}
