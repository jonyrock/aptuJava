package spbau.velikiy.task1;

/**
 * Message Writer in a file
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class ConsoleMessageWriter implements MessageWriter {

    private int messageCount = 0;

    /**
     * Write one message in console
     *
     * @param m message to write in console
     */
    public void writeMessage(Message m) {

        messageCount++;

        System.out.println("Message " + messageCount);
        int i = 0;

        for (String s : m.getLines()) {

            i++;
            System.out.println(messageCount + "." + i + ". " + s);

        }

    }

    /**
     * Do nothing. It`s interface requirement.
     */
    public void close() {

    }

}
