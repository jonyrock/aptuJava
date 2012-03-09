package spbau.velikiy.task3.core;

public class OperationDivision extends Tree {

    public int value(int xValue){

        // lazy evaluation
        int leftValue = left.value(xValue);
        if(leftValue == 0)
            return 0;
        
        return leftValue / right.value(xValue);
    }

}