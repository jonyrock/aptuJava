package spbau.velikiy.task1;

/**
 * Message Writer which merge two messages in one
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class CompressingMessageWriter implements MessageWriter {

    private MessageWriter nativeWriter;
    private boolean isFirst;
    private Message compressedMessage;

    /**
     * Constructor from lower writer
     *
     * @param nativeWriter is inner writer which used for real writing
     */
    public CompressingMessageWriter(final MessageWriter nativeWriter) {
        this.nativeWriter = nativeWriter;
        isFirst = true;
    }

    /**
     * Adds message to stream. Second append to first.
     *
     * @param m message for forward processing
     */
    public void writeMessage(Message m) throws MessageWriterException {

        if (isFirst) {
            compressedMessage = new Message();
            compressedMessage.append(m);
            isFirst = false;
        } else {
            compressedMessage.append(m);
            nativeWriter.writeMessage(compressedMessage);

            isFirst = true;
        }

    }

    /**
     * Writes last message if second omitted
     *
     * @throws MessageWriterException from inner writer
     */
    public void close() throws MessageWriterException {

        try {
            if (!isFirst)
                nativeWriter.writeMessage(compressedMessage);
        } finally {
            nativeWriter.close();
        }


    }
}
