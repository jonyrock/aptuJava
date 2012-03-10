package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;
import spbau.velikiy.task3.exceptions.ParserParsingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationVar extends Tree {

    public final String name;
    private static final Pattern VAR_PATTERN = Pattern.compile("([a-zA-Z]+)");

    /**
     * Create var from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     * @throws ParserParsingException if can't parse
     */
    public OperationVar(char[] s, int pointer) throws ParserParsingException {

        CharSequence seq = java.nio.CharBuffer.wrap(s, pointer, s.length - pointer);
        Matcher matcher = VAR_PATTERN.matcher(seq);
        if (matcher.find()) {
            name = matcher.group(1);
        } else {
            throw new ParserParsingException("Expected letters");
        }

    }

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant evaluate
     * @throws ParserEvaluationException if error is occurred
     */
    public int evaluate(EvaluationContext context) throws ParserEvaluationException {
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