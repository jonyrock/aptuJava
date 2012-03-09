package spbau.velikiy.task3;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.ExpressionsTreeParser;
import spbau.velikiy.task3.core.Tree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticParser extends ExpressionsTreeParser {


    private final EvaluationContext context;
    final static Pattern functionDefinitionPattern = Pattern.compile("([a-zA-Z]+)\\(([a-zA-Z]+)");

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

    public int evaluate() {
        return this.getRootTree().value(this.context);
    }

}
