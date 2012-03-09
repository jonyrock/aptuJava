package spbau.velikiy.task3.core;

public class OperationVar extends Tree {

    public final String name;

    public OperationVar(char[] s, int pointer) {

        StringBuilder builder = new StringBuilder();


        while (pointer < s.length) {
            
            if (!Character.isLetter(s[pointer])){
                break;
            }
            
            builder.append(s[pointer]);
            pointer++;
        }

        name = builder.toString();

    }

    public int value(int xValue) {

        return xValue;

    }

}