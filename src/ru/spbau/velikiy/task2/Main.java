package spbau.velikiy.task2;

import java.io.FileNotFoundException;

/**
 * Simple directories list
 *
 * @author Alexey Velikiy. APTU. Java. Homework 2.
 * @version %I%, %G%
 */
public class Main {

    /**
     * Start point
     *
     * @param args input (and output) file paths
     */
    public static void main(String[] args) {

        try {

            if (args.length < 1) {
                System.err.println("Need directory path as first param");
                System.exit(1);
            }

            FilesystemWalker walker = new FilesystemWalker(
                    args[0], new PatternFilter("[^\\.].*"), System.out);

            walker.list();

        } catch (FileNotFoundException e) {
            
            System.err.println(e.getMessage());
            System.exit(2);
            
        }

    }

}
