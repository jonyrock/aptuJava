package spbau.velikiy.task3.core;


import spbau.velikiy.task3.exceptions.ParserEvaluationException;

import java.util.HashMap;

public class EvaluationContext {

    /**
     * contains defined vars
     */
    protected HashMap<String, Tree> mapVars = new HashMap<String, Tree>();

    /**
     * contains defined functions with their argument name
     */
    protected HashMap<String, FunctionArgumentTree> mapFunctions =
            new HashMap<String, FunctionArgumentTree>();

    /**
     * get var definition
     *
     * @param name var name
     * @return evaluated expression bounded with var
     * @throws ParserEvaluationException when can't find definition
     */
    public int getVarValue(String name) throws ParserEvaluationException {

        Tree t = mapVars.get(name);
        if (t == null) {
            throw new ParserEvaluationException("Undefined var " + name);
        }
        return t.value(this);
    }

    /**
     * get function and evaluate it with certain argument value
     *
     * @param name  var name
     * @param value is value for function argument
     * @return evaluated expression bounded with var
     * @throws ParserEvaluationException when can't find definition
     */
    public int evalFunction(String name, int value) throws ParserEvaluationException {

        FunctionArgumentTree t = mapFunctions.get(name);

        if (t == null) {
            throw new ParserEvaluationException("Undefined function " + name);
        }
        return t.tree.value(
                new FunctionEvaluationContext(t.argumentName,
                        value, this));

    }


    /**
     * Add new var definition in context
     *
     * @param varName var name
     * @param tree    evaluation tree
     */
    public void addVarValue(String varName, Tree tree) {
        mapVars.put(varName, tree);
    }

    /**
     * Add new function definition
     *
     * @param name    function name
     * @param argName function argument name
     * @param tree    function evaluation tree
     */
    public void addFunctionValue(String name, String argName, Tree tree) {
        mapFunctions.put(name, new FunctionArgumentTree(argName, tree));
    }

    private static class FunctionEvaluationContext extends EvaluationContext {

        public final int argumentValue;
        public final String argumentName;

        public FunctionEvaluationContext(String argumentName, int argumentValue,
                                         EvaluationContext baseContext) {

            this.argumentName = argumentName;
            this.argumentValue = argumentValue;

            super.mapFunctions = baseContext.mapFunctions;
            super.mapVars = baseContext.mapVars;

        }

        @Override
        public int getVarValue(String name) throws ParserEvaluationException {
            if (argumentName.equals(name)) {
                return argumentValue;
            }
            return super.getVarValue(name);
        }
    }

    private static class FunctionArgumentTree {

        public String argumentName;
        public Tree tree;

        public FunctionArgumentTree(String argumentName, Tree tree) {
            this.argumentName = argumentName;
            this.tree = tree;
        }

    }

}
