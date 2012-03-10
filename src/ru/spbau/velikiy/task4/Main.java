package spbau.velikiy.task4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Arithmetic Parser. With functions definitions.
 * Start point
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */

public class Main {

    /**
     * Start point
     *
     * @param args program source path
     */
    public static void main(String[] args) {
        
        System.out.println("asdasdasd");
        

    }

    private static String[] getSourceLines(String sourceFile) {

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(sourceFile));

            ArrayList<String> sourceLines = new ArrayList<String>();
            while (reader.ready()) {
                sourceLines.add(reader.readLine());
            }

            return sourceLines.toArray(new String[sourceLines.size()]);

        } catch (FileNotFoundException e) {
            System.out.println("Can't read file " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while reading");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.exit(1);
        return null;


    }

}
