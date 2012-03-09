package spbau.velikiy.task3.core;

public class OperationPlus extends Tree {

    public int value(EvaluationContext context) {
        return left.value(context) + right.value(context);
    }

}