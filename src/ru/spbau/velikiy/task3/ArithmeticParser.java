package spbau.velikiy.task3;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.ExpressionsTreeParser;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements all business logic 
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public class ArithmeticParser extends ExpressionsTreeParser {

    private final EvaluationContext context;
    private final static Pattern functionDefinitionPattern = Pattern.compile("([a-zA-Z]+)\\(([a-zA-Z]+)");

    /**
     * construct program structure from code
     * @param programSource expression in lines
     */
    public ArithmeticParser(String[] programSource) {

        super(programSource[programSource.length - 1]);

        this.context = new EvaluationContext();

        for (int i = 0; i < programSource.length - 1; i++) {

            String[] parts = programSource[i].replace(" ", "").split("=");

            Tree tree = new ExpressionsTreeParser(parts[1]).getRootTree();

            if (parts[0].contains("(")) {

                Matcher matcher = functionDefinitionPattern.matcher(parts[0]);
                if (!matcher.find())
                    throw new RuntimeException("Wrong definition");

                String functionName = matcher.group(1);
                String argumentName = matcher.group(2);

                context.addFunctionValue(functionName, argumentName, tree);

            } else {
                
                context.addVarValue(parts[0], tree);
                
            }

        }

    }

    /**
     * evaluate last expression from sources lines 
     * 
     * @return integer calculateValue
     * @throws ParserEvaluationException if can't evaluate 
     */    
    public int evaluate() throws ParserEvaluationException {        
        return this.getRootTree().calculateValue(this.context);
    }

}
