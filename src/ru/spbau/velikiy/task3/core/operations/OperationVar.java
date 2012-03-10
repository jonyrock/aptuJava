package spbau.velikiy.task3.core.operations;

import spbau.velikiy.task3.core.EvaluationContext;
import spbau.velikiy.task3.core.Tree;
import spbau.velikiy.task3.exceptions.ParserEvaluationException;

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

    public int value(EvaluationContext context) throws ParserEvaluationException{

        return context.getVarValue(this.name);

    }

    @Override
    public String getVarName() {
        return this.name;
    }
}