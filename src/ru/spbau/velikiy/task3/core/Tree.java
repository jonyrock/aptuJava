package spbau.velikiy.task3.core;

public abstract class Tree implements ValueAble {

    public Tree left;
    public Tree right;

    public Tree operationsFabric(char op){
        
        if(op == '+')
            return new OperationPlus();

        if(op == '-')
            return new OperationMinus();

        if(op == '/')
            return new OperationDivision();

        if(op == '*')
            return new OperationMultiplication();

        return null;

    }

}
