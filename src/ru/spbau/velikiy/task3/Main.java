package spbau.velikiy.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    // TODO stop throw exception 
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Bad params. Need input file path.");
            System.exit(1);
        }

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        ArrayList<String> sourceLines = new ArrayList<String>();
        while (reader.ready()) {
            sourceLines.add(reader.readLine());
        }
        
        ArithmeticParser parser = new ArithmeticParser(
                sourceLines.toArray(new String[sourceLines.size()]));
        
        System.out.println(parser.evaluate());
        
    }

}
