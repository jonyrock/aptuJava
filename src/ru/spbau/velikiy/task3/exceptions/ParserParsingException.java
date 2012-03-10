package spbau.velikiy.task3.exceptions;


/**
 * Represent exception occurred during parsing
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public class ParserParsingException extends Exception{
    public ParserParsingException(String message){
        super(message);
    }
}
