package spbau.velikiy.task1;

import java.io.*;

/**
 * Wrapper for reading messages from file by one
 *
 * @author Alexey Velikiy
 * @version %I%, %G%
 */
public class FileMessageReader {

    private BufferedReader reader;

    /**
     * Constructor from input file
     *
     * @param path path to input file
     * @throws FileNotFoundException if can`t find input file
     */
    public FileMessageReader(String path) throws FileNotFoundException {

        reader = new BufferedReader(
                new FileReader(path));

    }

    /**
     * Read one message from input file
     *
     * @return parsed message
     * @throws IllegalMessageFormatException when file has wrong format
     * @throws IOException                   when can`t correctly close file after exception
     */
    public Message readMessage() throws IllegalMessageFormatException,
            IOException {

        int currentRow = 1;

        try {

            Message tmp = new Message();

            String s = reader.readLine();
            currentRow++;

            if (s == null) {
                reader.close();
                return null;
            }

            int rowsCountInteger = Integer.parseInt(s);

            for (int i = 1; i <= rowsCountInteger; i++) {
                String line = reader.readLine();
                if (line == null)
                    throw new IllegalMessageFormatException(
                            "Expected more lines. Error at line " + currentRow);
                tmp.append(line);
                currentRow++;
            }

            return tmp;

        } catch (IOException e) {
            throw new IOException("Reading issue. Error at line " + currentRow, e);
        } catch (NumberFormatException e) {
            throw new IllegalMessageFormatException(
                    "Wrong file format. Error at line " + currentRow);
        }

    }

    /**
     * close reader for insurance
     *
     * @throws IOException when can`t close stream correctly
     */
    public void close() throws IOException {
        reader.close();
    }

}
