package spbau.velikiy.task1;

/**
 * Exception which describes wrong messages file format
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class IllegalMessageFormatException extends Exception {

    /**
     * Default constructor with setting exception message
     *
     * @param message exception message text
     */
    public IllegalMessageFormatException(String message) {
        super(message);
    }

}
