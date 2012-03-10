package spbau.velikiy.task3.core;

import spbau.velikiy.task3.core.operations.*;

/**
 * Expression structure tree.
 * It is structure. Java know nothing about this.
 * http://msdn.microsoft.com/ru-ru/library/ms228600(v=vs.90).aspx
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public abstract class Tree implements Evaluable {

    public Tree left;
    public Tree right;

    /**
     * Get operation by operation char
     *
     * @param op operation char
     * @return operation or null if it is not exist
     */
    public static Tree operationsFabric(char op) {

        switch (op) {

            case '+':
                return new OperationPlus();

            case '-':
                return new OperationMinus();

            case '/':
                return new OperationDivision();

            case '*':
                return new OperationMultiplication();

            case '@':
                return new OperationApply();

            default:
                return null;
        }

    }

    /**
     * This method uses for retrieving additional information
     * about inner vars
     *
     * @return name of
     */
    public String getVarName() {
        throw new NullPointerException("Not implemented");
    }

}
