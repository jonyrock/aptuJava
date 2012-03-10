package spbau.velikiy.task3.core;


/**
 * Structure represent meta information about expression. 
 * It is structure. Java know nothing about this.
 * http://msdn.microsoft.com/ru-ru/library/ms228600(v=vs.90).aspx
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */

public class ExpressionMark {

    /**
     * type of char in expression
     */
    public MarkType type;

    /**
     * specific value for each type
     */
    public int value;

    /**
     * expression mark types
     */
    public static enum MarkType{
        Bracket,
        Num,
        Var,
        BiOperation
    }
    

}

