package spbau.velikiy.task3.core;

public class ExpressionMark {

    enum MarkType{
        Bracket,
        Num,
        Var,
        BiOperation
    }

    MarkType type;
    int value;

}
