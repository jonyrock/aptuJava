package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;

public class OperationPlus extends Tree {

    public int value(EvaluationContext context) {
        return left.value(context) + right.value(context);
    }

}