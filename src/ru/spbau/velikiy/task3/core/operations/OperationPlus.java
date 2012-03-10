package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

public class OperationPlus extends Tree {

    public int value(EvaluationContext context)throws ParserEvaluationException {
        return left.value(context) + right.value(context);
    }

}