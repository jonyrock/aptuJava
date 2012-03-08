package spbau.velikiy.task1;

import java.io.*;

/**
 * Simple messages processing application.
 *
 * @author Alexey Velikiy. APTU. Java. Homework 1.
 * @version %I%, %G%
 */
public class Main {
    /**
     * Start point
     *
     * @param args input (and output) file paths
     */
    public static void main(String[] args) {


        FileMessageReader reader = null;
        MessageWriter writer = null;

        int exitCode = 0;

        try {

            if (args.length < 1) {
                System.out.println("Need input file path in first param");
                exitCode = 1;
                return;
            }

            reader = new FileMessageReader(args[0]);


            if (args.length == 1) {
                writer = new CompressingMessageWriter(
                        new ConsoleMessageWriter());
            } else {
                writer = new CompressingMessageWriter(
                        new FileMessageWriter(args[1]));
            }

            for (Message m = reader.readMessage(); m != null;
                 m = reader.readMessage()) {

                writer.writeMessage(m);

            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
            exitCode = 2;
        } catch (IllegalMessageFormatException e) {
            System.out.println(e.getMessage());
            exitCode = 3;
        } catch (MessageWriterException e) {
            System.out.println(e.getCause().getMessage());
            exitCode = 4;
        } finally {
            try {
                if (writer != null)
                    writer.close();
                if (reader != null)
                    reader.close();
            } catch (MessageWriterException e) {
                System.out.println(e.getCause().getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        System.exit(exitCode);

    }

}
