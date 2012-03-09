package spbau.velikiy.task3.core;

/**
 * Interface for evaluation
 */

public interface ValueAble {

    /**
     * 
     * evaluate expression according to context
     * 
     * @param context definitions of vars
     * @return expression evaluated value
     */
    int value(EvaluationContext context);

}
