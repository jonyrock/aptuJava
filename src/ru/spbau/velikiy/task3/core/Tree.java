package spbau.velikiy.task3.core;

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
    public Tree operationsFabric(char op){
        
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

}
