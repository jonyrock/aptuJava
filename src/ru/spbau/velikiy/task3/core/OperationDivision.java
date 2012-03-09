package spbau.velikiy.task3.core;

public class OperationDivision extends Tree {

    public int value(int xValue){       
        return left.value(xValue) / right.value(xValue);
    }

}