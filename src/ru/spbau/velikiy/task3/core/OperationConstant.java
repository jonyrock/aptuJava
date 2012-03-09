package spbau.velikiy.task3.core;


public class OperationConstant extends Tree {

    private final int value;

    /**
     * Create constant from source string expression
     * and pointer in it
     *
     * @param s       source expression
     * @param pointer position in expression
     */
    public OperationConstant(char[] s, int pointer) {

        int parsedValue = 0;

        while (pointer < s.length) {
            if (!Character.isDigit(s[pointer])) {
                break;
            }
            parsedValue = parsedValue * 10 + Character.digit(s[pointer], 10);
            pointer++;
        }
        
        value = parsedValue;        

    }


    public OperationConstant(int value) {
        this.value = value;
    }

    public int value(int xValue) {

        return value;

    }

}