package spbau.velikiy.task3.core;


import java.util.HashMap;

public class EvaluationContext {

    protected HashMap<String, Tree> mapVars = new HashMap<String, Tree>();
    protected HashMap<String, FunctionArgumentTree> mapFunctions = 
            new HashMap<String, FunctionArgumentTree>();

    public int getVarValue(String name) {
        return mapVars.get(name).value(this);
    }

    public int evalFunction(String name, int value) {
        FunctionArgumentTree item = mapFunctions.get(name);
        
        return item.tree.value(
                new FunctionEvaluationContext(item.argumentName, 
                        value, this));
    }


    /**
     * Add new var definition in context
     * @param varName var name
     * @param tree evaluation tree
     */
    public void addVarValue(String varName, Tree tree) {
        mapVars.put(varName, tree);
    }

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
        public int getVarValue(String name) {            
            if(argumentName.equals(name)){
                return argumentValue;
            }            
            return super.getVarValue(name);
        }
    }
    
    private static class FunctionArgumentTree {
        
        public String argumentName;
        public Tree tree;
        
        public FunctionArgumentTree(String argumentName, Tree tree){
            this.argumentName = argumentName;
            this.tree = tree;
        }
        
    }
    
}
