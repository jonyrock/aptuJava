package spbau.velikiy.task1;

/**
 * Holder for exceptions occurred in writing time
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class MessageWriterException extends Exception {

    /**
     * Inheritance Exception behavior
     */
    public MessageWriterException() {
        super();
    }

    /**
     * Inheritance Exception behavior
     */
    public MessageWriterException(java.lang.String message) {
        super(message);
    }

    /**
     * Inheritance Exception behavior
     */
    public MessageWriterException(java.lang.String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    /**
     * Inheritance Exception behavior
     */
    public MessageWriterException(java.lang.Throwable cause) {
        super(cause);
    }

}
