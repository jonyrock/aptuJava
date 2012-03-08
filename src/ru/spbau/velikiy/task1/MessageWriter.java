package spbau.velikiy.task1;

/**
 * MessageWriter is interface for all kinds of
 * writing messages
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public interface MessageWriter {
    /**
     * Method of writing message
     *
     * @param m message to write
     * @throws MessageWriterException when can`t write. See cause.
     */
    void writeMessage(Message m) throws MessageWriterException;

    /**
     * Execute it when writing will be finished
     */
    void close() throws MessageWriterException;

}
