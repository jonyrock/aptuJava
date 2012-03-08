package spbau.velikiy.task1;

import java.io.*;
import java.util.List;

/**
 * Message Writer in a file
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class FileMessageWriter implements MessageWriter {

    private BufferedWriter writer;

    /**
     * Default constructor from file path
     *
     * @param path path to output file
     * @throws IOException throws when can`t create
     */
    public FileMessageWriter(String path) throws IOException {

        writer = new BufferedWriter(new FileWriter(path));

    }

    /**
     * Writes one message in file and flush
     *
     * @param m message to write
     * @throws RuntimeException when tries write.
     *                          See RuntimeException.getCause()
     */
    public void writeMessage(Message m) throws MessageWriterException {

        try {

            List<String> lines = m.getLines();

            writer.write(lines.size() + "");
            writer.newLine();

            for (String s : lines) {

                writer.write(s);
                writer.newLine();

            }

            writer.flush();

        } catch (IOException e) {
            throw new MessageWriterException(e);
        }

    }

    /**
     * Close inner file stream
     *
     * @throws MessageWriterException when can`t close. See exception cause.
     */
    public void close() throws MessageWriterException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new MessageWriterException(e);
        }
    }

}
