package spbau.velikiy.task3.core;

public abstract class Tree<T extends ExpressionType> implements ValueAble<T> {

    public Tree<T> left;
    public Tree<T> right;

    public Tree<T> operationsFabric(char op){

        if(op == '+')
            return new OperationPlus<T>();

        if(op == '-')
            return new OperationMinus<T>();

        if(op == '/')
            return new OperationDivision<T>();

        if(op == '*')
            return new OperationMultiplication<T>();

        return null;

    }

}
