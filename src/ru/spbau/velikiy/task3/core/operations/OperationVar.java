package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationVar extends Tree {

    public final String name;

    /**
     * Create var from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     */
    public OperationVar(char[] s, int pointer) {

        StringBuilder builder = new StringBuilder();

        while (pointer < s.length) {

            if (!Character.isLetter(s[pointer])) {
                break;
            }

            builder.append(s[pointer]);
            pointer++;

        }

        name = builder.toString();

    }

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant calculateValue
     * @throws ParserEvaluationException if error is occurred
     */
    public int calculateValue(EvaluationContext context) throws ParserEvaluationException {

        return context.getVarValue(this.name);

    }

    /**
     * Return var name for using as function var
     *
     * @return var name
     */
    @Override
    public String getVarName() {
        return this.name;
    }
}