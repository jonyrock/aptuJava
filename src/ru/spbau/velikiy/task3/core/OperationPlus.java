package spbau.velikiy.task3.core;

public class OperationPlus extends Tree {

    public int value(int xValue) {
        return left.value(xValue) + right.value(xValue);
    }

}