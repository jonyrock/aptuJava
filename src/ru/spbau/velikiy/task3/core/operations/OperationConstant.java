package spbau.velikiy.task3.core.operations;


import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;

public class OperationConstant extends Tree {

    private final int value;

    /**
     * Create constant from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     */
    public OperationConstant(char[] s, int pointer) {

        int parsedValue = 0;

        while (pointer < s.length) {

            if (!Character.isDigit(s[pointer])) {
                break;
            }

            parsedValue = parsedValue * 10 + Character.digit(s[pointer], 10);
            pointer++;

        }

        value = parsedValue;

    }

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant value
     */
    public int value(EvaluationContext context) {

        return value;

    }

}