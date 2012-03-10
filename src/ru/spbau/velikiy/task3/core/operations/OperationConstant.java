package spbau.velikiy.task3.core.operations;


import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserParsingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationConstant extends Tree {

    private final int value;
    private static final Pattern CONSTANT_PATTERN = Pattern.compile("(\\d+)");

    /**
     * Create constant from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     * @throws ParserParsingException if can't parse
     */
    public OperationConstant(char[] s, int pointer) throws ParserParsingException {
        
        CharSequence seq = java.nio.CharBuffer.wrap(s, pointer, s.length - pointer);
        Matcher matcher = CONSTANT_PATTERN.matcher(seq);
        if (matcher.find()) {
            value = Integer.parseInt(matcher.group(1));
        } else {
            throw new ParserParsingException("Expected digits");
        }


    }

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant evaluate
     */
    public int evaluate(EvaluationContext context) {

        return value;

    }

}