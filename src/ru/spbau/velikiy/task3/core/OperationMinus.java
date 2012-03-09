package spbau.velikiy.task3.core;

public class OperationMinus extends Tree {

    public int value(int xValue) {
        
        // if it is unary minus
        if(left == null){
            return -right.value(xValue);
        }
        
        // otherwise it is binary
        return left.value(xValue) - right.value(xValue);
        
    }

}