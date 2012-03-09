package spbau.velikiy.task3.core;

import spbau.velikiy.task3.core.operations.*;

/**
 * Expression structure tree
 */
public abstract class Tree implements ValueAble {
    
    public Tree left;
    public Tree right;

    /**
     * 
     * Get operation by operation char
     * 
     * @param op operation char
     * @return operation
     */
    public static Tree operationsFabric(char op){
        
        if(op == '+')
            return new OperationPlus();

        if(op == '-')
            return new OperationMinus();

        if(op == '/')
            return new OperationDivision();

        if(op == '*')
            return new OperationMultiplication();

        if(op == '@')
            return new OperationApply();
        
        return null;

    }

    /**
     * This method uses for retrieving additional information
     * about inner vars
     * 
     * @return name of 
     */
    public String getVarName(){
        throw new NullPointerException("Not implemented");
    }
    
}
