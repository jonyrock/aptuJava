package spbau.velikiy.task3.core;


import java.util.HashMap;

public class EvaluationContext {

    private HashMap<String, Tree> mapVars = new HashMap<String, Tree>();
    private HashMap<String, Tree> mapFunctions = new HashMap<String, Tree>();

    public int getVarValue(String name) {
        return mapVars.get(name).value(this);
    }

    public int evalFunction(String name, int value) {
        return 123;
    }


    /**
     * Add new var definition in context
     * @param varName var name
     * @param tree evaluation tree
     */
    public void addVarValue(String varName, Tree tree) {
        mapVars.put(varName, tree);
    }

    public void addFunctionValue(String name, String argName, Tree expr) {

    }

    private class FunctionEvaluationContext extends EvaluationContext {

        public FunctionEvaluationContext() {
            
        }

    }
    
    
    
}
