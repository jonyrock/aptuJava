package spbau.velikiy.task3.core;

import spbau.velikiy.task3.exceptions.ParserEvaluationException;

/**
 * Interface for computable objects
 * 
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */

public interface ValueAble {

    /**    
     * evaluate expression according to context
     * 
     * @param context definitions of vars
     * @return expression evaluated calculateValue
     * @throws ParserEvaluationException if error is occurred
     */
    int calculateValue(EvaluationContext context) throws ParserEvaluationException;

}
