package spbau.velikiy.task3.core.operations;


import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserParsingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationConstant extends Tree {

    private final int value;
    private static final Pattern constantPattern = Pattern.compile("(\\d+).*?");

    /**
     * Create constant from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     * @throws ParserParsingException if can't parse
     */
    public OperationConstant(char[] s, int pointer) throws ParserParsingException {

        int parsedValue = 0;

        CharSequence seq = java.nio.CharBuffer.wrap(s, pointer, s.length);
        Matcher matcher = constantPattern.matcher(seq);
        if (matcher.matches()) {
            value = Integer.parseInt(matcher.group(1));
        } else {
            throw new ParserParsingException("Expected digits");
        }


    }

    /**
     * evaluate expression according to context
     *
     * @param context definitions of vars.
     * @return constant calculateValue
     */
    public int calculateValue(EvaluationContext context) {

        return value;

    }

}